function submitOrder() {
  const note = document.getElementById("orderNote").value;
  const deliveryTime = document.getElementById("deliveryTimeInput").value;
  const total = document.getElementById("grand-total").textContent;

  if (!deliveryTime) {
    alert("Lütfen teslimat saatini seçin.");
    return;
  }

  alert(`🧡 Siparişiniz alındı!\nTeslim edilecek saat: ${deliveryTime}\nTutar: ₺${total}\nNot: ${note || "Yok"}`);
}
