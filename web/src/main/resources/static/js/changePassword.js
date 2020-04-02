var check = function() {
    if (document.getElementById('newPassword').value ==
        document.getElementById('confirmNewPassword').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'Password are matching';
    } else {
            document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'Password NOT matching';
    }
}