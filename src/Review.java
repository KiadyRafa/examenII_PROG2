import java.time.LocalDate;

class Review {
    private String reviewerName;
    private String reviewerEmail;
    private int score;
    private String comment;
    private LocalDate date;

    public Review(String reviewerName, String reviewerEmail, int score, String comment, LocalDate date) {
        this.reviewerName = reviewerName;
        this.reviewerEmail = reviewerEmail;
        this.score = score;
        this.comment = comment;
        this.date = date;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    public int getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getDate() {
        return date;
    }
}

