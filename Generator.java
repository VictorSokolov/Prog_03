package pswsearch; // @author Victor

import java.util.*;

public class Generator { // Генератор ключей
	private int LenghtKey = 1; // Длина ключа
	private String FirstKey = "", CurrKey = "", LastKey = ""; // Сюда расчитаем и положим первый, текущий и последний ключ
	private HashSet[] SymbolsSet = new HashSet[LenghtKey]; // Массив коллекций символов для каждой позиции Set потому что дублей в перечне символов не должно быть

// ? Ниже избыточный конструктор?
public Generator(int lenghtKey) { // Конструктор Известна длина ключа, в любом разряде - любые символы
	LenghtKey = lenghtKey; SymbolsSet = new HashSet[LenghtKey];
	for (int i = 0; LenghtKey > i; i++) // Напихать во все разряды все символы
		SymbolsSet[i] = {"1", "2", "3", "a", "b", "c", "A", "B", "C"}; // Потом вписать всё остальное
                calcFKey(); CurrKey = FirstKey; calcLKey(); // Определить FirstKey, CurrKey, LastKey
}
public Generator(HashSet[] symbolsSet) { // Конструктор Известны наборы допустимых значений для каждого символа
	SymbolsSet = symbolsSet; LenghtKey = SymbolsSet.length;
	calcFKey(); CurrKey = FirstKey; calcLKey(); // Определить FirstKey, CurrKey, LastKey
}

public Generator(HashSet symbolsSet[], String currKey) { // Конструктор Известны наборы допустимых значений для каждого символа и начальная комбинация
	SymbolsSet = symbolsSet; LenghtKey = SymbolsSet.length;
	FirstKey = currKey; CurrKey = currKey; calcLKey(); // Определить FirstKey, CurrKey, LastKey
}

private void calcFKey() { // Расчитать первую комбинацию ключа
	char[] key = new char[LenghtKey];
	for ( HashSet i : SymbolsSet) // for (int i = 1; LenghtKey > i; i++) key[i] = SymbolSet[i].first();
		key[i] = i.first(); // Вернуть первый символ из коллекции
	FirstKey = key.toString();
}
private void calcLKey() { // Расчитать последнюю комбинацию ключа
	char key[] = new char[LenghtKey];
	for ( HashSet i : SymbolsSet)
		key[i] = i.last(); // Вернуть первый символ из коллекции
	LastKey = key.toString();
}
public boolean hasNext() { return CurrKey.equals(LastKey); } // Текущий ключ последний?
public int lenght() { // Длина ключа
	return SymbolsSet.length; // return LenghtKey;
}
public String getNextKey() { // Расчёт следующей комбинации ключа
	char key[] = CurrKey.toCharArray(); // Строковый ключ в массив символов
	for (int i = 1; key.lenght() > i; i++) { // для всех символов ключа начиная с первого
		SymbolsSet[i].set(key[i]) // Стать на тождественный текущему элементу ключа элемент в соответствующей коллекции допустимых
			if SymbolsSet[i].hasNext() { // Если не последний элемент в коллекции
				key[i] = SymbolsSet[i].Next();
				CurrKey = key.toString();
				break;
			} else // Если последний, то присвоить символу первый допустимый и изменить символ в следующей позиции
				key[i] = SymbolsSet[i].first();
	}
	return key.toString();
}
// public static void main(String arg[]) {} не нужно
}