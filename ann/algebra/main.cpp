#include <bits/stdc++.h>
#include "fract.hpp"
#include "matrix.hpp"
#include "func.hpp"

void __debugParser__();
void __debugFraction__();

int main(){

	int tam1, tam2;
	cout << "Tam matriz: "; cin >> tam1 >> tam2;
	cout << "Criando matriz\n";
	Matrix * mat = new Matrix(tam1,tam2);
	cout << "Matriz criada\n";
	mat->show();
	cout << "\n";
	cout << "Entre com fracoes no formato a/b\n";
	cout << "Lendo matriz " << tam1 << "x" << tam2 << "\n";

	for(int i=0; i<tam1; i++){
		for(int j=0; j<tam2; j++){
			Fraction * tmp = parseInput();
			mat->insertData(tmp, i, j);
		}
	}

	mat->show();
	cout << endl;
	mat->scal();
	mat->show();
	cout << endl;
}


void __debugParser__(){
	Fraction * n;
	n = parseInput();
	cout << "a";
	cout << n->show() << "\n";
}

void __debugFraction__(){
	Fraction * a = new Fraction(1, 3);
	Fraction * b = new Fraction(4, 6);
	Fraction aa = *a;
	Fraction bb = *b;
	/*cout << a->mul(*b)->show() << endl;
	cout << a->add(*b)->show() << endl;
	cout << a->sub(*b)->show() << endl;
	*/
	cout << (aa*bb)->show() << endl;
	cout << (aa+bb)->show() << endl;
	cout << (bb+5)->show() << endl;
	cout << (*(aa*bb)+5)->show() << endl;
}