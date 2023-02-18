(function () {
  "use strict";

  window.addEventListener(
    "load",
    function () {
      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.getElementsByClassName("needs-validation");

      // Loop over them and prevent submission
      Array.prototype.filter.call(forms, function (form) {
        form.addEventListener(
          "submit",
          function (event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add("was-validated");
          },
          false
        );
      });
    },
    false
  );
})();

function checkUserId() {
  const userId = document.getElementById("userId").value;
  var validEmailRegex =
    /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

  if (!userId) {
    document
      .getElementById("userId")
      .setCustomValidity("ユーザIDを入力してください");
    document.getElementById("userIdInvalidFeedback").innerHTML =
      "ユーザIDを入力してください";
    return;
  }

  if (!userId.match(validEmailRegex)) {
    document
      .getElementById("userId")
      .setCustomValidity("メールアドレスの形式で入力してください");
    document.getElementById("userIdInvalidFeedback").innerHTML =
      "メールアドレスの形式で入力してください";
  } else {
    document.getElementById("userId").setCustomValidity("");
  }
}

function checkPassword() {
  const password = document.getElementById("password").value;

  if (!password) {
    document
      .getElementById("password")
      .setCustomValidity("パスワードを入力してください");
    document.getElementById("passwordInvalidFeedback").innerHTML =
      "パスワードを入力してください";
    return;
  }

  if (password.length < 8) {
    document
      .getElementById("password")
      .setCustomValidity("8文字以上にしてください");
    document.getElementById("passwordInvalidFeedback").innerHTML =
      "8文字以上にしてください";
  } else {
    document.getElementById("password").setCustomValidity("");
  }
}
