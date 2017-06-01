
var currentUser = null;
var locale = "ru";
var currentPageName = "contentMain";
include("js/SPA_JS.js");
include("js/services/services.js");
include("js/testimonials/testimonials.js");
include("js/booking/booking.js");
function include(url) {
    var script = document.createElement('script');
    script.src = url;
    document.getElementsByTagName('head')[0].appendChild(script);
}

function setRoleAttributes(roleObj) {
    for(var fieldRole in roleObj)
        currentUser['role'][fieldRole] = roleObj[fieldRole];
}

$( document ).ready(function() {
    if(sessionStorage.length!=0) {
        document.getElementById('idAdminRef').style.display = 'block';
        currentUser = {
            'role':{}
        };
        for (var fieldUser in sessionStorage) {
            if (fieldUser == 'role')
                setRoleAttributes(JSON.parse(sessionStorage['role']));
            else
                currentUser[fieldUser] = sessionStorage[fieldUser];
        }
        loadTemplate('/templates/pages/signin/personalInfo.html');
        setNewValueEntryDiv(currentUser.name);
        generatePermissionsUser();
    }else{
        document.getElementById('idAdminRef').style.display = 'none';
    }
});

function generatePermissionsUser() {
    var objRole = currentUser['role'];
    var stringPermissions ='';

    for(var permission in objRole)
        if(permission!='id') {
            stringPermissions += objRole[permission];
        }
}
function findRoom() {
    alert("Ловушка! Тут-то ничего нет! Тебе в услуги!")
}
function preparationMain() {

    $.ajax({
        type: 'GET',
        url: '/servlet?&rights=4&localePage=contentMain&locale=' + locale,
        success: function(data) {
          //  alert("kek");
            setData(data['local']);
        }
    });
}

function setData(data) {
    //alert("tut");
    console.log("---------------------")
    console.log(data);
    for(var key in data) {
        //alert(key);
        if (document.getElementById(key) !=null){
            document.getElementById(key).innerHTML = data[key];
        }
    }
}

function changeLocale(loc) {
    $.ajax({
        type: 'GET',
        url: '/servlet?rights=4&localePage=' + currentPageName + '&locale=' + loc,
        success: function(data) {
            /*console.log(JSON.stringify(data));
            console.log(data['data']);
            console.log(data['local']);
            console.log(data['local']['address']);
            console.log("uuuuuuuuuuuu");*/
            locale = loc;
            console.log("2222222222")
            console.log(data)
            setData(data['local']);
        }

    });
}
