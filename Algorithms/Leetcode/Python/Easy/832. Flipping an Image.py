class Solution:
    def flipAndInvertImage(self, image):
        return [[1 ^ pixel for pixel in row[::-1]]for row in image]

def main():
    image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    sol = Solution()
    print(sol.flipAndInvertImage(image))

if __name__ == "__main__":
    main()