s=input().strip()
vowels=['a','e','i','o','u']
maxlen=0
dictt={0:-1}
counter=0
for i in range(len(s)):
    if s[i] in vowels:
        counter+=1
    else:
        counter-=1
    
    if counter in dictt:
        maxlen=max(maxlen,i-dictt[counter])
    else:
        dictt[counter]=i

print(maxlen)


