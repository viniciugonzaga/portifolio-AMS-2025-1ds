// C++ code
//
void setup(){
 // Definindo os pinos como saídas
  for (int pin = 2; pin <= 13; pin++) {
    pinMode(pin, OUTPUT);
  }
}

void loop() {
   // Dupla 1 (Norte-Sul) verde e Dupla 2 (Leste-Oeste) vermelha
  // Semáforos Norte e Sul (verdes)
  digitalWrite(2, HIGH);    // Semáforo 1 (Norte - verde)
  digitalWrite(3, LOW);     // Semáforo 1 (Norte - amarelo)
  digitalWrite(4, LOW);     // Semáforo 1 (Norte - vermelho)
  
  digitalWrite(5, HIGH);    // Semáforo 2 (Sul - verde)
  digitalWrite(6, LOW);     // Semáforo 2 (Sul - amarelo)
  digitalWrite(7, LOW);     // Semáforo 2 (Sul - vermelho)

  // Semáforos Leste e Oeste (vermelhos)
  digitalWrite(8, LOW);     // Semáforo 3 (Leste - verde)
  digitalWrite(9, LOW);     // Semáforo 3 (Leste - amarelo)
  digitalWrite(10, HIGH);   // Semáforo 3 (Leste - vermelho)

  digitalWrite(11, LOW);    // Semáforo 4 (Oeste - verde)
  digitalWrite(12, LOW);    // Semáforo 4 (Oeste - amarelo)
  digitalWrite(13, HIGH);   // Semáforo 4 (Oeste - vermelho)

  delay(6000);  // Atraso de 6 segundos (verde para Norte-Sul)

  // Dupla 1 (Norte-Sul) amarelo e Dupla 2 (Leste-Oeste) vermelha
  // Semáforos Norte e Sul (amarelos)
  digitalWrite(2, LOW);     // Semáforo 1 (Norte - verde)
  digitalWrite(3, HIGH);    // Semáforo 1 (Norte - amarelo)
  digitalWrite(4, LOW);     // Semáforo 1 (Norte - vermelho)
  
  digitalWrite(5, LOW);     // Semáforo 2 (Sul - verde)
  digitalWrite(6, HIGH);    // Semáforo 2 (Sul - amarelo)
  digitalWrite(7, LOW);     // Semáforo 2 (Sul - vermelho)

  // Semáforos Leste e Oeste (vermelhos)
  digitalWrite(8, LOW);     // Semáforo 3 (Leste - verde)
  digitalWrite(9, LOW);     // Semáforo 3 (Leste - amarelo)
  digitalWrite(10, HIGH);   // Semáforo 3 (Leste - vermelho)

  digitalWrite(11, LOW);    // Semáforo 4 (Oeste - verde)
  digitalWrite(12, LOW);    // Semáforo 4 (Oeste - amarelo)
  digitalWrite(13, HIGH);   // Semáforo 4 (Oeste - vermelho)

  delay(2000);  // Atraso de 2 segundos (amarelo para Norte-Sul)

  // Dupla 1 (Norte-Sul) vermelha e Dupla 2 (Leste-Oeste) verde
  // Semáforos Norte e Sul (vermelhos)
  digitalWrite(2, LOW);     // Semáforo 1 (Norte - verde)
  digitalWrite(3, LOW);     // Semáforo 1 (Norte - amarelo)
  digitalWrite(4, HIGH);    // Semáforo 1 (Norte - vermelho)
  
  digitalWrite(5, LOW);     // Semáforo 2 (Sul - verde)
  digitalWrite(6, LOW);     // Semáforo 2 (Sul - amarelo)
  digitalWrite(7, HIGH);    // Semáforo 2 (Sul - vermelho)

  // Semáforos Leste e Oeste (verdes)
  digitalWrite(8, HIGH);    // Semáforo 3 (Leste - verde)
  digitalWrite(9, LOW);     // Semáforo 3 (Leste - amarelo)
  digitalWrite(10, LOW);    // Semáforo 3 (Leste - vermelho)

  digitalWrite(11, HIGH);   // Semáforo 4 (Oeste - verde)
  digitalWrite(12, LOW);    // Semáforo 4 (Oeste - amarelo)
  digitalWrite(13, LOW);    // Semáforo 4 (Oeste - vermelho)

  delay(6000);  // Atraso de 6 segundos (verde para Leste-Oeste)

  // Dupla 1 (Norte-Sul) vermelha e Dupla 2 (Leste-Oeste) amarelo
  // Semáforos Norte e Sul (vermelhos)
  digitalWrite(2, LOW);     // Semáforo 1 (Norte - verde)
  digitalWrite(3, LOW);     // Semáforo 1 (Norte - amarelo)
  digitalWrite(4, HIGH);    // Semáforo 1 (Norte - vermelho)
  
  digitalWrite(5, LOW);     // Semáforo 2 (Sul - verde)
  digitalWrite(6, LOW);     // Semáforo 2 (Sul - amarelo)
  digitalWrite(7, HIGH);    // Semáforo 2 (Sul - vermelho)

  // Semáforos Leste e Oeste (amarelos)
  digitalWrite(8, LOW);     // Semáforo 3 (Leste - verde)
  digitalWrite(9, HIGH);    // Semáforo 3 (Leste - amarelo)
  digitalWrite(10, LOW);    // Semáforo 3 (Leste - vermelho)

  digitalWrite(11, LOW);    // Semáforo 4 (Oeste - verde)
  digitalWrite(12, HIGH);   // Semáforo 4 (Oeste - amarelo)
  digitalWrite(13, LOW);    // Semáforo 4 (Oeste - vermelho)

  delay(2000);  // Atraso de 2 segundos (amarelo para Leste-Oeste)
  
  
}
  