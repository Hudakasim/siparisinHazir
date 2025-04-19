let currentProductId = null; // Şu anki ürün ID'si
let extraOptionsHTML = '';

// Popup'ı göster
function showPopup(productId) {
	currentProductId = productId;
	const productName = document.querySelector(`#product-${productId} h4`).innerText;
	const popup = document.getElementById('popup');

	if (productId <= 12) {
		document.getElementById('product-name').innerText = `${productName} - Ek malzeme eklemek ister misin? `;
		burgerPopup(popup);
	}
	else if (productId > 12 && productId <= 17){
		document.getElementById('product-name').innerText = `${productName} - Kaç parça seçmek istersiniz?`;
		sidePopup(popup, productId);
	}
	else{
		document.getElementById('product-name').innerText = `${productName} - Kaç tane seçmek istersiniz?`;
		quantityPopup(popup);
	}

	document.getElementById('extra-options').innerHTML = extraOptionsHTML;
	popup.style.display = 'block';
	document.getElementById('product-name').classList.add('product-name-style');

	// Sayacı sıfırla
	document.getElementById('quantity-value').innerText = '1';
  }

function addToCart() {
	const quantityValue = document.getElementById('quantity-value').innerText;
	const productName = document.querySelector(`#product-${currentProductId} h4`).innerText;
	let extraMessage = "";

	if(currentProductId <= 12){
        const extraCheckboxes = document.querySelectorAll('#extra-options input[type="checkbox"]:checked');

        // Seçilen ekstra malzemeleri ekle
        if (extraCheckboxes.length > 0) {
            extraCheckboxes.forEach(checkbox => {
                extraMessage += `${checkbox.nextElementSibling.innerText}, `;
            });
            extraMessage = `(Ekstra Malzemeler: ${extraMessage.slice(0, -2)})`;
		}
		alert(`${quantityValue} adet ${productName} ${extraMessage}sepete eklendi.`);

	}else if (currentProductId > 12 && currentProductId <= 17) {
		const selectedSize = document.querySelector('input[type="radio"]:checked');
		if (!selectedSize) {
		  alert('Lütfen atistirmaniniz kac parcali olcaigini secin.');
		  return; // Fonksiyonu sonlandır, sepete ekleme işlemini yapma
		}
		const selectedSizeValue = selectedSize.value;

		// Sepete ekleme mesajı
		alert(`${quantityValue} adet ${productName} (${selectedSizeValue}) sepete eklendi.`);

	}else{
		alert(`${quantityValue} adet ${productName} sepete eklendi.`);
	}

	// Popup'ı kapat
	closePopup();
  }

function burgerPopup(popup){
	extraOptionsHTML =`
	<input type="checkbox" id="Cheese" name="extra" value="Cheese"><label for="Cheese">Peynir</label><br>
	<input type="checkbox" id="Pickles" name="extra" value="Pickles"><label for="Pickles">Turşu</label><br>
	<input type="checkbox" id="Lettuce" name="extra" value="Lettuce"><label for="Lettuce">Marul</label><br>
	<input type="checkbox" id="Mushroom" name="extra" value="Mushroom"><label for="Mushroom">Mantar</label><br>
	`;
	document.getElementById('quantity-control').style.display = 'flex';
	popup.className = 'popup popup-hamburger';
}

function sidePopup(popup, productId){
	if (!(productId == 16 || productId == 17)){
		extraOptionsHTML =`
		<input type="radio" id="4luk" name="boyut" value="4'lü" onclick="showQuantityControl()"><label for="4luk">4'lü</label><br>
		<input type="radio" id="6lik" name="boyut" value="6'lı" onclick="showQuantityControl()"><label for="6lik">6'lı  (+20₺)</label><br>
		<input type="radio" id="8lik" name="boyut" value="8li" onclick="showQuantityControl()"><label for="8lik">8'li  (+30₺)</label><br>
		`;
	}else{
		extraOptionsHTML =`
		<input type="radio" id="Small" name="boyut" value="Small" onclick="showQuantityControl()">
		<label for="Small">Small</label><br>
		<input type="radio" id="Medium" name="boyut" value="Medium" onclick="showQuantityControl()">
		<label for="Medium">Medium (+20₺)</label><br>
		<input type="radio" id="Large" name="boyut" value="Large" onclick="showQuantityControl()">
		<label for="Large">Large (+30₺)</label><br>
		`;
	}

	document.getElementById('quantity-control').style.display = 'none';
	popup.className = 'popup popup-side';
}

function quantityPopup(popup){
	extraOptionsHTML =``;
	document.getElementById('quantity-control').style.display = 'flex';
	popup.className = 'popup popup-quantity';
}
