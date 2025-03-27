function toggleCartButtons() {
	// "Sepete Ekle" butonunu gizle
	const addToCartButton = document.querySelector(".add-to-cart");
	addToCartButton.style.display = "none";

	// Artı/eksi butonlarını göster
	const quantityControl = document.querySelector(".quantity-control");
	quantityControl.style.display = "flex";
  }

  function updateQuantity(amount) {
	const quantitySpan = document.getElementById("quantity");
	let quantity = parseInt(quantitySpan.innerText);

	// Yeni miktarı hesapla
	quantity += amount;

	// Sayı 0'a düşerse artı/eksi butonlarını gizle ve "Sepete Ekle"yi tekrar göster
	if (quantity <= 0) {
	  quantity = 1;
	  document.querySelector(".quantity-control").style.display = "none";
	  document.querySelector(".add-to-cart").style.display = "flex";
	}

	// Miktarı güncelle
	quantitySpan.innerText = quantity;
  }

function showMenu(menuId) {
	// tüm menüleri gizle
	const sections = document.querySelectorAll('.menu-section');
	sections.forEach(section => {
	  section.style.display = 'none';
	});

	// seçilen menüyü göster
	const activeSection = document.getElementById('menu-' + menuId);
	if (activeSection) {
	  activeSection.style.display = 'block';
	}
  }
