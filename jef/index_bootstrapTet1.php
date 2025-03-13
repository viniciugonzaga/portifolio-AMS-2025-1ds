<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Bootstrap</title>
</head>
<body>


<div class="container">
  
<nav class="navbar navbar-expand-lg bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="#">Sistema Web</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active text-white" aria-current="page" href="#">Cadastrar</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled text-white" aria-disabled="true">Consultar</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

 <br>
 <br>
<h4>Cadastrar-Agendamento de Potencias Clientes</h4>
<br>
<p>Sistema utilizado para agendamento de serviços</p>


<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Nome:</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
  <label for="exampleFormControlInput1" class="form-label">Telefone:</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
  <label for="exampleFormControlInput1" class="form-label">Origem:</label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
  <div class="mb-3">
      <label for="disabledSelect" class="form-label">Disabled select menu</label>
      <select id="disabledSelect" class="form-select">
        <option>Celular</option>
      </select>
    </div>
    <div class="mb-3">
    <label for="dateInput" class="form-label">Data</label>
    <div class="input-group">
      <input type="date" class="form-control" id="dateInput" aria-describedby="calendarIcon">
      <span class="input-group-text" id="calendarIcon">
        <i class="fas fa-calendar-alt"></i>
      </span>
    </div>
  </div>
  <div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Observações</label>
  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
<button type="button" class="btn btn-primary">Cadastrar</button>
</div>

  




    
    


</body>
</html>