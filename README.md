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
- jeżeli obie daty są wybrane, klikamy przycisk rezerwuj
Po kliknięciu ("Rezerwuj")
- jeżeli data przyjazdu jest mniejsza od daty wyjazdu(czyli wyjeżdżamy później niż przyjezdzamy na miejsce) program automatycznie je podmienia
- wyliczanie długości wyjazdu
- wypisanie długości wyjazdu

......................................
         Prostota w działaniu
...................................... 
- po uruchomieniu pojawia się gotowy program
- natychmiast możemy przejść do użytkowania
- wszytywanie blokad następuje automatycznie
- po wyłączeniu aplikacja się resetuje
