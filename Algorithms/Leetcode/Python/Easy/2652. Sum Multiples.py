class Solution:
    def sumOfMultiples(self, n):
        def is_valid(i):
            return i % 3 == 0 or i % 5 == 0 or i % 7 == 0
        return sum(i for i in range(1, n+1) if is_valid(i))
    
def main():
    n = int(input("input number : "))
    print(Solution().sumOfMultiples(n))

if __name__ == "__main__":
    main()