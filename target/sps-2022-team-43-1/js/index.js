async function getRandomTip() {
    const response = await fetch("/random-tip"); // TODO(ferdeleong): Talk with Zhe to agree on an endpoint name.
    const data = await response.json();
    const randomTip = document.getElementById("random-tip"); // TODO(ferdeleong): Talk with Rishith to agree on an HTML name.
    randomTip.innerHTML = data[Math.floor(Math.random() * data.length)];
}