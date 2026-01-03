class Solution:
    def finalPositionOfSnake(self, n, commands):
        i = 0
        j = 0

        for d in commands:
            if d == "UP":
                i -= 1
            elif d == "DOWN":
                i += 1
            elif d == "RIGHT":
                j += 1
            elif d == "LEFT":
                j -= 1
        
        return (i * n) + j
            
                
def main():
    n = 3
    commands = ["RIGHT","DOWN"]
    sol = Solution()
    print(sol.finalPositionOfSnake(n, commands))

if __name__ == "__main__":
    main()