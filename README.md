......................................
            Działanie
......................................   
Program służy do wyliczania długosci wyjazdu, przy użyciu kalendarza:
- możliwość zaznaczenia daty wyjazdu i przyjazdu;
- blokuje zaznaczanie daty wstecz
- blokuje zaznaczanie daty wyjazdu ponad 2 lata w przyszłość

......................................
            Funkcjonalność
...................................... 
Po uruchomieniu ukazuje się:
- kalendarz służący do zaznaczania daty
- przycisk ("Data wyjazdu") służący do pobierania i zapisywania daty wyjazdu 
- przycisk ("Data przyjazdu") służący do pobierania i zapisywania daty przyjazdu
- przycisk ("Rezerwuj") służący do uruchamiania skryptu wyliczającego długość pobytu
- pola tekstowe, w których miejscu pojawiają się dane

......................................
         Testowanie działania
...................................... 
- automatyczne wczytanie blokady dla daty z przeszłośći
- automatyczne wczytanie blokady dla daty z przyszłośći(powyżej 2 lat)
- wybieramy date na kalendarzu i zaznaczamy (przyjazd/wyjazd) odpowiednim przyciskiem
- jeżeli obie daty są wybrane, dostępny pojawia się przycisk rezerwuj
