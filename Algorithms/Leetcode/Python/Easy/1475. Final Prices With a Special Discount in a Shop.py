class Solution:
    def finalPrices(self, prices):
        stack = []
        n = len(prices)
        result = prices[:]
        for i in range(n):
            while stack and prices[i] <= prices[stack[-1]]:
                idx = stack.pop()
                result[idx] -= prices[i]
            stack.append(i)
        return result

def main():
    prices = [8,4,6,2,3]
    sol = Solution()
    print(sol.finalPrices(prices))

if __name__ == "__main__":
    main()