class Solution:
    def convertTemperature(self, celsius):
        return [celsius + 273.15, celsius * 1.80 + 32.00]

def main():
    celsius = float(input())
    print(Solution().convertTemperature(celsius))
    
if __name__ == "__main__":
    main()