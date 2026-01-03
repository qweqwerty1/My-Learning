class Solution:
    def defangIPaddr(self, address):
        return address.replace(".","[.]")

def main():
    address = input().strip()
    print(Solution().defangIPaddr(address))

if __name__ == "__main__":
    main()