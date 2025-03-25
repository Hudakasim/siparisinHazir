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
