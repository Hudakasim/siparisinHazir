let currentProductId = null; // Şu anki ürün ID'si

// Popup'ı göster
function showPopup(productId) {
  currentProductId = productId; // Hangi ürünü popup'a göndereceğimizi saklıyoruz

  const productName = document.querySelector(`#product-${productId} h4`).innerText; // Ürün adını al
  const productPrice = document.querySelector(`#product-${productId} .price`).innerText; // Ürün fiyatını al
  const popup = document.getElementById('popup');
  popup.style.display = 'block'; // Popup'ı göster

  // Popup başlığını dinamik olarak değiştirme
  document.getElementById('product-name').innerText = `${productName} - Boyut Seçin`;

  // Sayacı sıfırla
  document.getElementById('quantity-value').innerText = '1';
  document.getElementById('quantity-control').style.display = 'none';

  // Fiyat bilgisini de göster
  // Burada ihtiyacınıza göre fiyat bilgisi de popup'ta gösterilebilir.
  // Örnek: document.getElementById('product-price').innerText = productPrice;
}

// Popup'ı kapat
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

// Boyut seçildiğinde quantity control görünür hale gelir
function showQuantityControl() {
  document.getElementById('quantity-control').style.display = 'flex'; // Sayacı göster
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

// Sepete Ekle butonuna tıklandığında
function addToCart() {
  // Boyut seçimi yapılmış mı kontrol et
  const selectedSize = document.querySelector('input[type="radio"]:checked');

  if (!selectedSize) {
    alert('Lütfen içeceğinizin boyutunu seçin.');
    return; // Fonksiyonu sonlandır, sepete ekleme işlemini yapma
  }

  const productName = document.querySelector(`#product-${currentProductId} h4`).innerText;
  const quantityValue = document.getElementById('quantity-value').innerText;
  const selectedSizeValue = selectedSize.value;

  // Sepete ekleme mesajı
  alert(`${quantityValue} adet ${productName} (${selectedSizeValue}) sepete eklendi.`);

  // Popup'ı kapat
  closePopup();
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
