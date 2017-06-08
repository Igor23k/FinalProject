
$personalForm = null;
var reservationObject = {};

function setEventListener() {
    ($('#idAcceptUpdatePersonalInfo')[0]).addEventListener("click", updatePersonalInfo);
    ($('#idLogOutUser')[0]).addEventListener("click", LogOut);
}

function setPersonalInfo() {
    var editBody = document.getElementById('mainFormPersonalInfo');
    if($personalForm==null)
        $personalForm = editBody;
    $(editBody).each(function(){
        $("div",this).each(function(){
            if((this.className=='col-sm-9')) {
                if((this.firstElementChild).childNodes.length==0) {
                    $(this.firstElementChild).val(currentUser[$(this.firstElementChild).attr('name')]);
                }
            }
        });
    });
}

function loadTemplate(url) {
    var request = new XMLHttpRequest();
    request.open('GET', url);
    request.onreadystatechange = function() {
        if (request.readyState == 4) {
            if (request.status == 200) {
                if ( document.getElementById('entry') == null)
                    $('#personalInfo').html(request.responseText);
                else
                    $('#entry').html(request.responseText);
                if(currentUser!=null) {
                    setEventListener();
                    setPersonalInfo();
                }
            } else {
                alert('Network error, code: ' + request.status);
            }
        }
    };
    request.send(null);
}

function getUpdateDataUser() {
    var editBodyAdd = $('#mainFormPersonalInfo');
    var result = '';
    $(editBodyAdd).each(function(){
        $("div",this).each(function() {
            if(this.className=='col-sm-9') {
                var key = $(this.firstElementChild).attr('name');
                var value = $(this.firstElementChild).val();
                if(key == 'id' && value == ''){
                    value ="0";
                }else{
                    if($(this.firstElementChild).get(0).tagName == 'SELECT'){
                        value = value.substr(0,value.indexOf(' '))
                    }
                }
                result = result.concat('&',key,'=', value);
            }
        });
    });
    result = result.concat('&','id','=', currentUser.id);
    result = result.concat('&','banned','=', currentUser.banned);
    result = result.concat('&','idRole','=', currentUser.role.id);
    result = result.concat('&','password','=', currentUser.password);
    return result;
}

function sendUpdatePersonalInfo() {
    $.ajax({
        type: 'POST',
        url: '/servlet?action=UPDATE' + getUpdateDataUser() + '&rights=' + sessionStorage["rights"] +'&tableName=USER',
        success: function(data) {

        }
    });
}

function updatePersonalInfo() {
    var name = document.getElementById("name");
    var surname = document.getElementById("surname");
    var email = document.getElementById("email");
    var mobilePhone = document.getElementById("mobilePhone");
    var login = document.getElementById("login");
    var passportNumber = document.getElementById("passportNumber");
    var password = currentUser['password'];
    if(!validName(name.value) || !validName(surname.value) || !validPhone(mobilePhone.value) || !validEmail(email.value) ||
        !validLogin(login.value) || !validPassport(passportNumber.value))
    {
        alert ("Данные заполнены неверно!");
        return  false;
    }

    sendUpdatePersonalInfo();
}

function preparationGenerateReservations() {
    getTemplateReservations();
    getReservations();
}
$stateEntry = "entry"
$templateReservation = null;

function getTemplateReservations() {
    $.get("/templates/pages/signin/templateReservation.html", "html")
        .done(function(html){$templateReservation = html;})
        .fail(function(){ $templateReservation.html("failed to get:" + src); });
}

function getReservations() {
    $.ajax({
        type: 'GET',
        url: '/servlet?tableName=reservation_room&action=GET_ALL_BY_KEY&rights=' + sessionStorage["rights"] +'&&idUser=' + sessionStorage['id'] + '&localePage=contentServices&locale=' + locale,
        success: function(data) {
            generateReservations(data['data']);
        }
    });
}

function generateReservations(arrayReservations) {
    var countReservations = arrayReservations.length;
    var i;
    for(i=0;i<countReservations;i++){
        for(var fieldReservationObj in arrayReservations[i]) {
            if (fieldReservationObj == 'roomType') {
                parseRoomType(arrayReservations[i][fieldReservationObj]);
            } else {
                reservationObject[fieldReservationObj] = arrayReservations[i][fieldReservationObj];
            }
        }

        generateReservationHtml(reservationObject);
    }
}

function generateReservationHtml(reservationObj) {
    $('#personalInfo').append($templateReservation);
    console.log(reservationObj)
    var arrayComponentsListReservation = $(($('#personalInfo').children().last().children())[0]).children();
    arrayComponentsListReservation[0].innerHTML = "Бронь";
    arrayComponentsListReservation[1].lastElementChild.innerHTML = reservationObj["reservation"]["dateIn"];
    arrayComponentsListReservation[2].lastElementChild.innerHTML = reservationObj["reservation"]["dateOut"];
    arrayComponentsListReservation[3].lastElementChild.innerHTML = reservationObj["room"]["roomType"]["costPerDay"];
    arrayComponentsListReservation[4].lastElementChild.innerHTML = reservationObj["reservation"]["discount"]["countPercentages"];
    arrayComponentsListReservation[5].lastElementChild.innerHTML = reservationObj["room"]["floor"];
    arrayComponentsListReservation[6].lastElementChild.innerHTML = reservationObj["room"]["roomType"]["roomsCount"];
    arrayComponentsListReservation[7].lastElementChild.innerHTML = reservationObj["room"]["roomType"]["bedsCount"];
    arrayComponentsListReservation[8].lastElementChild.innerHTML = reservationObj["room"]["roomType"]["additionalInfo"];
}
var section;
function setNewValueEntryDiv(textDiv) {
    var entry = document.getElementById("singinHeader");
    entry.innerHTML = textDiv;
    if ($stateEntry == "entry") {
        entry.href = '#personalInfo';
        section = document.getElementById("entry");
        $stateEntry = "personalInfo";
        section.setAttribute('id', "personalInfo");
        section.setAttribute('src', "/templates/pages/signin/personalInfo.html");
    }else{
        entry.href = '#entry';
        section = document.getElementById("personalInfo");
        $stateEntry = "entry";
        section.setAttribute('id', "entry");
        section.setAttribute('src', "/templates/pages/signin/entry.html");
    }
}

function sendUserDataRegistration(login,email,pass,phone,name,surname,passport) {
    $.ajax({
        type: 'POST',
        url: '/servlet?action=REGISTRATION',
        data:{"locale":locale,"rights":4,"banned":0,"localePage":"personalInfo","login":login,"email":email,"password":pass,"mobilePhone":phone,"name":name,"surname":surname,"passportNumber":passport,"id":0,"idRole":1},
        success: function(data) {
            if(typeof data =='object') {
                alert("Вы успешно зарегистрировались!");
            }
        }
    });
}

function sendUserDataLogin(email,pass){
     $.ajax({
         type: 'POST',
         url: '/servlet?action=AUTHORIZATION',
         data:{"locale":locale,"localePage":"personalInfo","email":email,"password":pass},
         success: function(data) {
             if(typeof data['data'] =='object' && data['data']!=null) {
                 currentUser = data['data'];
                 if(sessionStorage.length==0) {
                     for (var fieldUser in currentUser) {
                         if (typeof currentUser[fieldUser] == 'object')
                             sessionStorage['rights'] = generatePermissionsUser(currentUser['role']);
                         else
                             sessionStorage[fieldUser] = currentUser[fieldUser];
                     }
                     if (sessionStorage['rights'] >= 127)
                         document.getElementById('idAdminRef').style.display = 'block';
                     loadTemplate('/templates/pages/signin/personalInfo.html');
                     setNewValueEntryDiv(currentUser.name);
                 }else
                 {
                     alert("Чет тут не но...")
                 }
             }else {
                 alert("Данные заполнены неверно!")
             }
         }
     });

}

function validateUpForm (){
    var name = document.getElementById("name");
    var surname = document.getElementById("surname");
    var passport = document.getElementById("passportNumber");

    var login = document.getElementById("login");
    var email = document.getElementById("emailUp");
    var password = document.getElementById("passUp");
    var phone = document.getElementById("mobilePhone");

    if (!validEmail(email.value) || !validPassword(password.value) || !validLogin(login.value)
        || !validPhone(phone.value)  || !validName(name.value)
        || !validName(surname.value) || !validPassport(passport.value)){
        alert ("Данные заполнены неверно!");
        return  false;
    }
    sendUserDataRegistration(login.value,email.value,password.value,phone.value,name.value,surname.value,passport.value);
}

function validateInForm (){
    var email = document.getElementById("emailIn");
    var passw = document.getElementById("passIn");

    if (!validEmail(email.value) || !validPassword(passw.value)){
        alert ("Данные заполнены неверно!");
        return  false;
    }
    alert ("Данные успешно отправлены на сервер!");
    sendUserDataLogin(email.value,passw.value);
}

function LogOut() {
    currentUser = null;
    sessionStorage.clear();
    setNewValueEntryDiv("Вход","#entry");
    loadTemplate('/templates/pages/signin/entry.html');
    document.getElementById('idAdminRef').style.display = 'none';
    $.ajax({
        type: 'POST',
        url: '/servlet?action=LOGOUT',
        data:{"locale":locale,"localePage":"personalInfo"}
    });
}

function validPassport(passport) {
    return (/(?=[a-zA-Z]{2}[0-9]{7})/).test(passport);
}
function validPhone(phone) {
    return (/(?=^\d[\d\(\)\ -]{4,14}\d$)/).test(phone);
}
function validName(name) {
    return (/(?=^[A-ZЁА-Я][a-zёа-я-_\.]{3,20}$)/).test(name);
}
function validLogin	(login) { //с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква
    return (/^[a-zA-z]{1}[a-zA-Z1-9]{3,20}$/).test(login);
}
function validEmail(email) {
    return (/^(?:[-a-z\d\+\*\/\?!{}`~_%&'=^$#]+(?:\.[-a-z\d\+\*\/\?!{}`~_%&'=^$#]+)*)@(?:[-a-z\d_]+\.){1,60}[a-z]{2,6}$/).test(email);
}
function validPassword(passw) {
    return (/(?=^.{8,}$)/).test(passw);
}

