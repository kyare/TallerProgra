#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

void pass(string words[], string clave,int lugar, string pre,int lugarW,int n) {

		if(clave.length() <= lugar) {
			cout<<pre<<endl;
		}
	else if(clave[lugar] == '#') {

             pass(words, clave, lugar +1, pre + words[lugarW],lugarW,n);
             if(lugarW<n){
                pass(words, clave, lugar +1, pre + words[lugarW],lugarW++,n);
             }
		}
		else if(clave[lugar] == '0') {

            pass(words, clave, lugar + 1, pre + '0',lugarW,n);
            pass(words, clave, lugar + 1, pre + '1',lugarW,n);
            pass(words, clave, lugar + 1, pre + '2',lugarW,n);
            pass(words, clave, lugar + 1, pre + '3',lugarW,n);
            pass(words, clave, lugar + 1, pre + '4',lugarW,n);
            pass(words, clave, lugar + 1, pre + '5',lugarW,n);
            pass(words, clave, lugar + 1, pre + '6',lugarW,n);
            pass(words, clave, lugar + 1, pre + '7',lugarW,n);
            pass(words, clave, lugar + 1, pre + '8',lugarW,n);
            pass(words, clave, lugar + 1, pre + '9',lugarW,n);

		}
	}
 int main(){

    int n=0;
    while(cin>>n){
        string words[100];
        string rules[1000];
        string word="";
        string rule="";
        int m=0;
        if(n>0 && n<=100){
            cout<<"--"<< endl;
            for (int i = 0; i < n; i++) {
					cin>>word;
					if(word.length() <= 256){
                        words[i]=word;
					}
            }
            cin>>m;
            if(m <= 1000){
                for (int i = 0; i < m; i++){
                    cin>>rule;
                    if(rule.length() <=256){
                        rules[i]=rule;
                    }
                }

                int j;

                    for ( j = 0; j < m; j++){
                        pass(words,rules[j],0,"",0,n);
                        rules[j]="";
                    }
            }
        }n=0;
    }
    return 0;
 }


