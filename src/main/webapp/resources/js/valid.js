
$( document ).ready()
{
    function isValid() {
        if ($("#password").val() != $("#password_confirmation").val()) {
            return false;
        } else {
            return true;
        }
    }
}
