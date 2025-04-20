function closePopup() {
  const popup = document.getElementById('popup');
  popup.style.display = 'none'; // Popup'ı gizle

  // Popup kapatıldığında quantity kontrolünü gizle
  const quantityControl = document.getElementById('quantity-control');
  quantityControl.style.display = 'none'; // Sayacı gizle

  // Boyutları sıfırla
  const radioButtons = document.querySelectorAll('input[type="radio"]');
  radioButtons.forEach(radio => {
    radio.checked = false;  // Seçili olanı sıfırla
  });

  // Popup kapatıldığında quantity değeri sıfırlansın
  const quantityValue = document.getElementById('quantity-value');
  quantityValue.textContent = '1';  // Sayacı sıfırla
}

function showQuantityControl() {
  document.getElementById('quantity-control').style.display = 'flex';
}

// Ürün sayısını güncelle
function updateQuantity(change) {
  const quantityValue = document.getElementById('quantity-value');
  let currentQuantity = parseInt(quantityValue.innerText);

  currentQuantity += change;

  // Sayı 0'dan küçük olamaz
  if (currentQuantity <= 0) {
    currentQuantity = 1;
    document.getElementById('quantity-control').style.display = 'none';  // Sayacı gizle
  } else {
    document.getElementById('quantity-control').style.display = 'flex'; // Sayacı göster
  }

  quantityValue.innerText = currentQuantity;
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

