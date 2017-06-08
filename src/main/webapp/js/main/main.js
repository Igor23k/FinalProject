
var currentUser = null;
var locale = "ru";
var currentPageName = "contentMain";

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
        if(permission!='id' && permission !='nameRole') {
            stringPermissions += objRole[permission];
        }
    console.log(stringPermissions)
    console.log(parseInt( stringPermissions, 2 ))
    return (parseInt( stringPermissions, 2 ));
}
function findRoom() {
    alert("Ловушка! Тут-то ничего нет! Тебе в услуги!")
}
var $countMatches = 0;
function preparationMain() {

    $.ajax({
        type: 'GET',
        url: '/servlet?&localePage=contentMain&locale=' + locale,
        success: function(data) {
          //  alert("kek");
            setData(data['local']);
        }
    });
}

function setData(data) {
    for(var key in data) {
        //alert(key);
        if (document.getElementById(key) !=null){
            if(key == "singinHeader" && sessionStorage.length != 0){
                data[key] = sessionStorage['login']
                //alert(key)
            }
            document.getElementById(key).innerHTML = data[key];
        }
    }
}

function changeLocale(loc) {
    $.ajax({
        type: 'GET',
        url: '/servlet?&localePage=' + currentPageName + '&locale=' + loc,
        success: function(data) {
            locale = loc;
            setData(data['local']);
        }
    });
}
