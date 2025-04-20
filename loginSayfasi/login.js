function showTab(tabName) {
    document.querySelectorAll('.form-section').forEach(section => section.classList.remove('active'));
    document.getElementById(tabName + 'Form').classList.add('active');

    document.querySelectorAll('.tab').forEach(tab => tab.classList.remove('active'));
    document.querySelector(`.tab[onclick="showTab('${tabName}')"]`).classList.add('active');
  }

  function loginUser(event) {
    event.preventDefault();
    const email = document.getElementById("loginEmail").value;
    const password = document.getElementById("loginPassword").value;

    if (!email || !password) {
      alert("Lütfen tüm alanları doldurun.");
      return false;
    }

    alert("Giriş başarılı!");
    // yönlendirme yapılabilir
    return false;
  }

  function registerUser(event) {
    event.preventDefault();
    const name = document.getElementById("registerName").value;
    const email = document.getElementById("registerEmail").value;
    const password = document.getElementById("registerPassword").value;

    if (!name || !email || !password) {
      alert("Tüm alanları doldurun.");
      return false;
    }

    alert("Kayıt başarılı!");
    return false;
  }
