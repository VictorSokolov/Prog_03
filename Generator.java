package pswsearch; // @author Victor

import java.util.*;

public class Generator { // ��������� ������
	private int LenghtKey = 1; // ����� �����
	private String FirstKey = "", CurrKey = "", LastKey = ""; // ���� ��������� � ������� ������, ������� � ��������� ����
	private HashSet[] SymbolsSet = new HashSet[LenghtKey]; // ������ ��������� �������� ��� ������ ������� Set ������ ��� ������ � ������� �������� �� ������ ����

// ? ���� ���������� �����������?
public Generator(int lenghtKey) { // ����������� �������� ����� �����, � ����� ������� - ����� �������
	LenghtKey = lenghtKey; SymbolsSet = new HashSet[LenghtKey];
	for (int i = 0; LenghtKey > i; i++) // �������� �� ��� ������� ��� �������
		SymbolsSet[i] = {"1", "2", "3", "a", "b", "c", "A", "B", "C"}; // ����� ������� �� ���������
                calcFKey(); CurrKey = FirstKey; calcLKey(); // ���������� FirstKey, CurrKey, LastKey
}
public Generator(HashSet[] symbolsSet) { // ����������� �������� ������ ���������� �������� ��� ������� �������
	SymbolsSet = symbolsSet; LenghtKey = SymbolsSet.length;
	calcFKey(); CurrKey = FirstKey; calcLKey(); // ���������� FirstKey, CurrKey, LastKey
}

public Generator(HashSet symbolsSet[], String currKey) { // ����������� �������� ������ ���������� �������� ��� ������� ������� � ��������� ����������
	SymbolsSet = symbolsSet; LenghtKey = SymbolsSet.length;
	FirstKey = currKey; CurrKey = currKey; calcLKey(); // ���������� FirstKey, CurrKey, LastKey
}

private void calcFKey() { // ��������� ������ ���������� �����
	char[] key = new char[LenghtKey];
	for ( HashSet i : SymbolsSet) // for (int i = 1; LenghtKey > i; i++) key[i] = SymbolSet[i].first();
		key[i] = i.first(); // ������� ������ ������ �� ���������
	FirstKey = key.toString();
}
private void calcLKey() { // ��������� ��������� ���������� �����
	char key[] = new char[LenghtKey];
	for ( HashSet i : SymbolsSet)
		key[i] = i.last(); // ������� ������ ������ �� ���������
	LastKey = key.toString();
}
public boolean hasNext() { return CurrKey.equals(LastKey); } // ������� ���� ���������?
public int lenght() { // ����� �����
	return SymbolsSet.length; // return LenghtKey;
}
public String getNextKey() { // ������ ��������� ���������� �����
	char key[] = CurrKey.toCharArray(); // ��������� ���� � ������ ��������
	for (int i = 1; key.lenght() > i; i++) { // ��� ���� �������� ����� ������� � �������
		SymbolsSet[i].set(key[i]) // ����� �� ������������� �������� �������� ����� ������� � ��������������� ��������� ����������
			if SymbolsSet[i].hasNext() { // ���� �� ��������� ������� � ���������
				key[i] = SymbolsSet[i].Next();
				CurrKey = key.toString();
				break;
			} else // ���� ���������, �� ��������� ������� ������ ���������� � �������� ������ � ��������� �������
				key[i] = SymbolsSet[i].first();
	}
	return key.toString();
}
// public static void main(String arg[]) {} �� �����
}