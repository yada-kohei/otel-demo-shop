(function () {
  'use strict';

  window.addEventListener('load', function () {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');

    // Loop over them and prevent submission
    Array.prototype.filter.call(forms, function (form) {
      form.addEventListener('submit', function (event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
}());

function checkUserId() {
  const userId = document.getElementById('userId').value;
  var validEmailRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

  if (!userId) {
    document.getElementById('userId').setCustomValidity('ユーザIDを入力してください');
    document.getElementById('userIdInvalidFeedback').innerHTML = 'ユーザIDを入力してください'
    return;
  }

  if (!userId.match(validEmailRegex)) {
    document.getElementById('userId').setCustomValidity('メールアドレスの形式で入力してください');
    document.getElementById('userIdInvalidFeedback').innerHTML = 'メールアドレスの形式で入力してください'
  } else {
    document.getElementById('userId').setCustomValidity('');
  }
}

function checkPassword() {
  const password = document.getElementById('password').value;

  if (!password) {
    document.getElementById('password').setCustomValidity('パスワードを入力してください');
    document.getElementById('passwordInvalidFeedback').innerHTML = 'パスワードを入力してください'
    return;
  }

  if (password.length < 8) {
    document.getElementById('password').setCustomValidity('8文字以上にしてください');
    document.getElementById('passwordInvalidFeedback').innerHTML = '8文字以上にしてください'
  } else {
    document.getElementById('password').setCustomValidity('');
  }
}

function checkBirthday() {
  const birthday = document.getElementById('birthday').value;
  var validDateRegex = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$"

  if (!birthday) {
    document.getElementById('birthday').setCustomValidity('誕生日を入力してください');
    document.getElementById('birthdayInvalidFeedback').innerHTML = '誕生日を入力してください'
    return;
  }

  if (!birthday.match(validDateRegex)) {
    document.getElementById('birthday').setCustomValidity('yyyy/MM/ddの形式で入力してください');
    document.getElementById('birthdayInvalidFeedback').innerHTML = 'yyyy/MM/ddの形式で入力してください'
  } else {
    document.getElementById('birthday').setCustomValidity('');
  }
}

function checkAge() {
  const age = document.getElementById('age').value;

  if (!age || age == 0 ) {
    document.getElementById('age').setCustomValidity('年齢を入力してください');
    document.getElementById('ageInvalidFeedback').innerHTML = '年齢を入力してください'
    return;
  }

  if (age < 20 || age > 100) {
    document.getElementById('age').setCustomValidity('20以上100以下の数値にしてください');
    document.getElementById('ageInvalidFeedback').innerHTML = '20以上100以下の数値にしてください'
  } else {
    document.getElementById('age').setCustomValidity('');
  }
}