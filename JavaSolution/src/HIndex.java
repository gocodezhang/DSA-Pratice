public class HIndex {
    public int hIndex(int[] citations) {
        // left = 0; right = n;
        int left = 0;
        int right = citations.length;
        int h = 0;
        // while (left < right)
        while (left <= right) {
            // h = left + right / 2
            int mid = (left + right) / 2;
            // count = 0;
            int count = 0;
            // for citation in citations
            for (int citation: citations) {
                if (mid <= citation) {
                    count += 1;
                }
            }
            // if (count >= mid)
            if (count >= mid) {
                h = Math.max(h, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // return h
        return h;
    }
    public int hIndexLinear(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        for (int citation: citations) {
            papers[Math.min(n, citation)]++;
        }
        int h = n;
        for (int s = papers[n]; h > s; s += papers[h]) {
            h--;
        }
        return h;
    }
    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex.hIndex(citations));
    }
}
