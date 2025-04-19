// Popup'ı göster
function showPopup(productId) {
	currentProductId = productId; // Hangi ürünü popup'a göndereceğimizi saklıyoruz
	const productName = document.querySelector(`#product-${productId} h4`).innerText; // Ürün adını al

	popup.style.display = 'block'; // Popup'ı göster

	// Popup başlığını dinamik olarak değiştirme
	document.getElementById('product-name').innerText = `${productName} - Boyut Seçin`;

	// Sayacı sıfırla
	document.getElementById('quantity-value').innerText = '1';
	document.getElementById('quantity-control').style.display = 'none';
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
