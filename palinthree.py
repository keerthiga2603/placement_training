string=input().strip()

left=[0 for _ in range(26)]
right=[0 for _ in range(26)]
for i in string:
    right[ord(i)-97]+=1

counter=0
for j in string:
    right[ord(j)-97]-=1
    
    arr=list(map(lambda x,y:x*y, left,right))
    counter+=sum(arr)
    left[ord(j)-97]+=1
print(counter)
