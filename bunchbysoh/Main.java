package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int ratedCapacity = 120;  // Rated capacity for all batteries

    for (int presentCapacity : presentCapacities) {
      
      // Skiping invalid capacity values i.e if it is less than 0 or greater than rated capacity.
      if (presentCapacity <= 0 || presentCapacity > ratedCapacity) {
            continue;
      }
      double soh = (100.0 * presentCapacity) / ratedCapacity;  // Calculate SoH percentage

      if (soh > 83) {
        counts.healthy++;
      } 
      else if (soh >= 63) {
        counts.exchange++;
      } 
      else {
        counts.failed++;
      }
    }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}