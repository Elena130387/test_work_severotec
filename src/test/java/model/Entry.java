package model;

import java.util.Objects;

public class Entry {
  private final String title;
  private final String slug;
  private final String text_markdown;
  private final String text;

  public Entry(String title, String slug, String text_markdown, String text) {
    this.title = title;
    this.slug = slug;
    this.text_markdown = text_markdown;
    this.text = text;
  }

  public String getTitle() {
    return title;
  }

  public String getSlug() {
    return slug;
  }

  public String getText_markdown() {
    return text_markdown;
  }

  public String getText() {
    return text;
  }

  @Override
  public String toString() {
    return "Entry{" +
            "title='" + title + '\'' +
            ", slug='" + slug + '\'' +
            ", text_markdown='" + text_markdown + '\'' +
            ", text='" + text + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Entry entry = (Entry) o;
    return Objects.equals(title, entry.title) && Objects.equals(slug, entry.slug) && Objects.equals(text_markdown, entry.text_markdown) && Objects.equals(text, entry.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, slug, text_markdown, text);
  }
}
