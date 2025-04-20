const cartItems = [
    {
      id: 1,
      name: "Cheddarlı Patates Kızartması",
      price: 95,
      qty: 2,
      image: "images/patates.jpg"
    },
    {
      id: 2,
      name: "Acı Sos",
      price: 35,
      qty: 1,
      image: "images/aci-sos.jpg"
    }
  ];

  function renderCart() {
    const container = document.getElementById("cart-container");
    container.innerHTML = "";

    let total = 0;

    cartItems.forEach(item => {
      const itemTotal = item.qty * item.price;
      total += itemTotal;

      const itemDiv = document.createElement("div");
      itemDiv.className = "cart-item";
      itemDiv.innerHTML = `
        <img src="${item.image}" alt="${item.name}">
        <div class="item-details">
          <h4>${item.name}</h4>
          <p>₺${item.price} x ${item.qty} = ₺${itemTotal}</p>
          <div class="controls">
            <button onclick="changeQty(${item.id}, -1)">-</button>
            <span>${item.qty}</span>
            <button onclick="changeQty(${item.id}, 1)">+</button>
          </div>
        </div>
      `;
      container.appendChild(itemDiv);
    });

    document.getElementById("grand-total").textContent = total.toFixed(2);
  }

  function changeQty(id, delta) {
    const itemIndex = cartItems.findIndex(i => i.id === id);
    if (itemIndex !== -1) {
      cartItems[itemIndex].qty += delta;

      if (cartItems[itemIndex].qty <= 0) {
        cartItems.splice(itemIndex, 1); // Ürünü kaldır
      }

      renderCart();
    }
  }

  function checkout() {
    const selected = document.querySelector('input[name="deliveryTime"]:checked');
    let deliveryTimeText = "belirtilmedi";

    if (selected) {
      if (selected.value === "other") {
        const otherTime = document.getElementById("otherTimeInput").value;
        deliveryTimeText = otherTime ? otherTime : "belirtilmedi";
      } else {
        // Radio'nun <label> içindeki metnini al
        const label = selected.closest("label");
        if (label) {
          deliveryTimeText = label.innerText.trim();
        } else {
          // Yedek olarak value'yı saat gibi göster
          deliveryTimeText = selected.value + ":00'da Al";
        }
      }
    }

    alert("Siparişiniz alınmıştır!\nTeslim Zamanı: " + deliveryTimeText);
  }

  // ✅ Radio butonlarından sadece biri seçilsin, tekrar tıklanınca kaldırılsın
  function setupDeliveryTimeToggle() {
    const radios = document.querySelectorAll('input[name="deliveryTime"]');
    let lastChecked = null;

    radios.forEach(radio => {
      radio.addEventListener("mousedown", function (e) {
        // Radio zaten seçiliyse kaldırmak için işaret koy
        if (radio === lastChecked) {
          radio.dataset.wasChecked = "true";
        } else {
          radio.dataset.wasChecked = "false";
        }
      });

      radio.addEventListener("click", function (e) {
        // Önceki tıklanan tekrar tıklanırsa kaldır
        if (radio.dataset.wasChecked === "true") {
          radio.checked = false;
          lastChecked = null;
          toggleOtherTimeInput(null);
          e.preventDefault();
        } else {
          lastChecked = radio;
          toggleOtherTimeInput(radio);
        }
      });
    });
  }

  // ✅ Diğer seçeneği seçilince saat girişi göster
  function toggleOtherTimeInput(radio) {
    const otherInput = document.getElementById("otherTimeInput");

    if (!radio || radio.value !== "other") {
      otherInput.style.display = "none";
      otherInput.value = ""; // input sıfırlansın
    } else {
      otherInput.style.display = "inline-block";
    }
  }



  // ✅ Sayfa yüklendiğinde çalıştır
  renderCart();
  setupDeliveryTimeToggle();

  const payment = document.querySelector('input[name="payment"]:checked');
if (!payment) {
  alert("Lütfen bir ödeme yöntemi seçin.");
  return;
}

