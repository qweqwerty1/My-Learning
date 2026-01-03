class Solution:
    def buildArray(self, target, n):
        result = []
        i = 0

        for num in range(1, n+1):
            
            if i == len(target):
                break

            if num == target[i]:
                result.append("Push")
                i += 1
            else:
                result.append("Push")
                result.append("Pop")
        
        return result

def main():
    target = [1,4,7]
    n = 7
    sol = Solution()
    print(sol.buildArray(target, n))

if __name__ == "__main__":
    main()