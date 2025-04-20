function goToMenu(page) {
  window.location.href = page;
}

const inputs = document.querySelectorAll(".input");

inputs.forEach((input) => {
  input.addEventListener("focus", () => {
    input.parentNode.classList.add("focus");
  });
  input.addEventListener("blur", () => {
    if (input.value === "") {
      input.parentNode.classList.remove("focus");
    }
  });
});

window.openLoginPopup = function () {
  document.getElementById("popupOverlay").style.display = "block";
  document.getElementById("loginPopup").style.display = "block";
  document.getElementById("registerPopup").style.display = "none";
};

window.closeLoginPopup = function () {
  document.getElementById("popupOverlay").style.display = "none";
  document.getElementById("loginPopup").style.display = "none";
};

window.openRegisterPopup = function () {
  document.getElementById("loginPopup").style.display = "none";
  document.getElementById("registerPopup").style.display = "block";
};

window.closeRegisterPopup = function () {
  document.getElementById("popupOverlay").style.display = "none";
  document.getElementById("registerPopup").style.display = "none";
};

window.registerUser = function (event) {
  event.preventDefault();
  const fullName = document.getElementById("fullName").value;
  const registerEmail = document.getElementById("registerEmail").value;
  const registerPassword = document.getElementById("registerPassword").value;

  if (!fullName || !registerEmail || !registerPassword) {
    alert("Tüm alanları doldurun.");
    return;
  }

  localStorage.setItem("userFullName", fullName);
  alert("Kayıt başarılı!");
  closeRegisterPopup();
  displayUserFullName();
};

window.loginUser = function (event) {
  event.preventDefault();
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  if (!email || !password) {
    alert("E-posta ve şifre girin.");
    return;
  }

  const fullName = localStorage.getItem("userFullName");
  if (fullName) {
    alert(`Merhaba, ${fullName}!`);
    displayUserFullName();
  }

  closeLoginPopup();
};

window.displayUserFullName = function () {
  const fullName = localStorage.getItem("userFullName");
  const welcome = document.getElementById("welcomeMessage");
  const span = document.getElementById("userFullName");

  if (fullName && welcome && span) {
    span.textContent = fullName;
    welcome.style.display = "block";
  }
};
window.addEventListener("DOMContentLoaded", () => {
  fetch("/loginSayfasi/login.html")
    .then(res => res.text())
    .then(html => {
      document.getElementById("popupContainer").innerHTML = html;
      displayUserFullName();
    });
});

