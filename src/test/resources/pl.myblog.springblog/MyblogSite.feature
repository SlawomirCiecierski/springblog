#language: pl
Funkcja:  Test funkcjonalności wybranego elementu GUI

#przekazać nazwę obiektu poddawanego testowi w Scenario
#w localhost localhost:8080/allposts/1
# ogsługuje przeglądarki w sekcji 'Zakładając' (linia 13)
# wpisać jedną z poniższych wartości:
#     chrome,
#     ie,
#     firefox
#     safari
  # opera
# słowa kluczowe scenariusza zostały spolszczone ku wygodzie użytkownika

  Szablon scenariusza: Testowanie wybranego GUI blogu

    Zakładając Użytkownik otworzy stronę komentarzy postu 'http://localhost:8080/allposts/18' w przeglądarce 'chrome'
    Gdy Użytkownik umieści komentarz o treści '<comment>' oraz '<content>'
    Wtedy Użytkownik spodziewa się bezawaryjnego działania w każdej ilości powtórzeń

    Przykłady: :
  | comment | content            |
  | name of | Content of comment |
  | name of | Content of comment |
