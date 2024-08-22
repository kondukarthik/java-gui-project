#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    vector<pair<int,int>>Balances(n);
    for(int i=0;i<n;i++){
        cin>>Balances[i].first>>Balances[i].second;
    }
    int t;
    cin>>t;
    int from_userID, to_userID, amount;
    for(int i=0;i<t;i++){
        cin>>from_userID>>to_userID>>amount;
        
        int toInd = -1, fromInd = -1;
        for(int j=0;j<n;j++){
            if(Balances[j].first == from_userID){
                fromInd = j;
            }
            if(Balances[j].first == to_userID){
                toInd = j;
            }
        }
        if (fromInd!=-1 && toInd!=-1 && Balances[fromInd].second >= amount){
            Balances[fromInd].second -= amount;
            Balances[toInd].second += amount;
            cout << "Success" <<"\n";
        } 
        else{
            cout<<"Failure"<<"\n";
        }
    }
    cout<<"\n";
    
    sort(Balances.begin(),Balances.end(),[](pair<int,int> a, pair<int,int> b){
        return a.second < b.second;
    });
    for(int i=0;i<n;i++){
        cout<<Balances[i].first<<" "<<Balances[i].second<<"\n";
    }
}