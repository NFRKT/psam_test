const categories = {
    "Chemia": ["Kosmetyki", "Środki czystości", "Inne - Chemia"],
    "Dzieci": ["Alimenty", "Art. szkolne i książki", "Kieszonkowe", "Kursy i zajęcia dodatkowe", "Odzież i buty", "Opieka", "Zabawki", "Inne - Dzieci"],
    "Edukacja": ["Czesne", "Kursy i szkolenia", "Nauka języków", "Pomoce naukowe", "Inne - Edukacja"],
    "Gotówka": ["Wypłata z bankomatu", "Inne - Gotówka"],
    "Inne": ["Działalność charytatywna", "Działalność społeczna", "Prezenty", "Zakupy internetowe/aukcje", "Inne - Inne"],
    "Inwestycje": ["Budowa domu", "Zakup akcji/obligacji/funduszy", "Zakup działki", "Zakup mieszkania", "Zakup samochodu", "Inne - Inwestycje"],
    "Koszty obsługi bankowej": ["Odsetki", "Opłaty i prowizje", "Inne - Koszt obsługi bankowej"],
    "Leczenie": ["Badania", "Dentysta", "Lekarstwa", "Okulary", "Ubezpieczenie zdrowotne", "Wizyty u lekarza", "Inne - Leczenie"],
    "Mieszkanie/dom": ["Akcesoria domowe", "Meble", "Ogród", "Remonty i naprawy", "Sprzęty RTV i AGD", "Ubezpieczenie zdrowotne", "Inne - Mieszkanie/dom"],
    "Odzież": ["Akcesoria galanteryjne", "Biżuteria", "Buty", "Ubrania", "Inne - Odzież"],
    "Podatki i opłaty administracyjne": ["Opłaty administracyjne", "Podatek dochodowy", "Podatek od nieruchomości", "VAT", "Inne - Podatki i opłaty administracyjne"],
    "Rachunki": ["Czynsz", "Energia", "Gaz", "Internet", "Ogrzewanie", "Radio", "Śmieci", "Telefon komórkowy", "Telefon stacjonarny", "TV", "Woda", "Inne - Rachunki"],
    "Rozrywka i hobby": ["Kino, teatr, koncerty", "Komputer i akcesoria", "Książki i prasa", "Restauracje", "Inne - Rozrywka i hobby"],
    "Sport i rekreacja": ["Akcesoria sportowe", "basen", "Ferie", "Fitness", "Netflix", "Siłownia", "SPA", "Wyjazdy wakacyjne", "Wyjazdy weekendowe", "Inne - Sport i rekreacja"],
    "Transport/samochód": ["Podróże lotnicze", "Samochód - akcesoria", "Samochód - paliwo", "Ubezpieczenia AC/OC/NW", "Inne - Transport/samochód"],
    "Usługi": ["Fryzjer", "Kosmetyczka", "Krawiec", "Naprawy sprzętu RTV i AGD", "Szewc", "Inne - Usługi"],
    "Zobowiązania kredytowe": ["Kredyt hipoteczny", "Kredyt samochodowy", "Kredyty gotówkowe", "Spłata karty kredytowej", "Spłata limitu w rachunku", "Inne - Zobowiązania"],
    "Zwierzęta": ["Akcesoria", "Karma", "Weterynarz", "Inne - Zwierzęta"],
    "Żywność": ["Art. spożywcze", "Używki", "Inne - Żywność", "jedzenie"]
  };
  
  export const categorizeExpense = (expenseName) => {
    // Przechodzimy przez kategorie i podkategorie, sprawdzamy, czy nazwa wydatku zawiera któreś z słów kluczowych
    for (const category in categories) {
      for (const subCategory of categories[category]) {
        if (expenseName.toLowerCase().includes(subCategory.toLowerCase())) {
          return { category, subCategory }; // Zwracamy kategorię i podkategorię
        }
      }
    }
    return { category: "Inne", subCategory: "Inne - Ogólne" }; // Jeśli nie znaleziono, przypisujemy "Inne"
  };
  