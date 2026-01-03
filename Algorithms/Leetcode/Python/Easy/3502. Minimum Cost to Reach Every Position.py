class Solution:
    def minCosts(self, cost):
        prev = cost[0]
        result = [prev]
        for i in cost[1:]:
            if i >= prev:
                result.append(prev)
            else:
                result.append(i)
                prev = i
        return result

def main():
    cost = [1,2,4,6,7]
    sol = Solution()
    print(sol.minCosts(cost))

if __name__ == "__main__":
    main()