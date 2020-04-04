var check = function() {
    if (document.getElementById('newPassword').value ==
        document.getElementById('confirmNewPassword').value) {
        document.getElementById('matchingMessage').style.color = 'green';
        document.getElementById('matchingMessage').innerHTML = 'Password are matching';
    } else {
            document.getElementById('matchingMessage').style.color = 'red';
        document.getElementById('matchingMessage').innerHTML = 'Password NOT matching';
    }
}