let currentProductId;
// Popup'ı göster
function showPopup(productId) {
	showQuantityControl();
	currentProductId = productId; // Hangi ürünü popup'a göndereceğimizi saklıyoruz
	const productName = document.querySelector(`#product-${productId} h4`).innerText; // Ürün adını al

	popup.style.display = 'block'; // Popup'ı göster

	// Popup başlığını dinamik olarak değiştirme
	document.getElementById('product-name').innerText = `${productName} - Boyut Seçin`;

	// Sayacı sıfırla
	document.getElementById('quantity-value').innerText = '1';
  }


// Sepete Ekle butonuna tıklandığında
function addToCart() {

	const productName = document.querySelector(`#product-${currentProductId} h4`).innerText;
	const quantityValue = document.getElementById('quantity-value').innerText;

	// Sepete ekleme mesajı
	alert(`${quantityValue} adet ${productName} sepete eklendi.`);

	// Popup'ı kapat
	closePopup();
  }
