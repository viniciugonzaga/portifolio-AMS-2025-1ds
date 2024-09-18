document.getElementById('image-upload').addEventListener('change', function(event) {
    const file = event.target.files[0]; // Obtenha o arquivo selecionado pelo usuário
    const reader = new FileReader(); // Crie um FileReader para ler o arquivo
  
    reader.onload = function(e) {
      const previewImage = document.getElementById('preview-img');
      previewImage.src = e.target.result; // Defina a fonte da imagem como o conteúdo lido
      previewImage.style.display = 'block'; // Mostre a imagem na página
    };
  
    if (file) {
      reader.readAsDataURL(file); // Leia o arquivo como uma URL de dados
    }
  });
  