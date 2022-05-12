import pandas
import cryptography
import nmap

def encryption(text, key):
    l1=['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    encryption=''
    for i, j in zip(text, key):
        ind=l1.index(i)
        indi=l1.index(j)
        final=(ind+indi)%26
        encryption+=l1[final]
    return encryption
        
def decryption(text, key):
    l1=['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
    cipher=''
    for i, j in zip(text, key):
        ind=l1.index(i)
        indi=l1.index(j)
        final=(ind-indi)%26
        cipher+=l1[final]
    return cipher
    
def pandasversion():
    a=pandas.__version__
    return a

def scanfromnmap(host):
    scanner=nmap.PortScanner()
    return scanner[host].state()
