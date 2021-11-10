package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NewObject {
    private String name;
    private String introductionText;
    private String exitText;
    private String introText;
    private String inText;
    private String introWord;
    private String introoWord;

    @Hidden
    @JsonProperty(value = "introoword")
    public String getIntrooWord() {
        return introoWord;
    }
    @JsonProperty(value = "introoWord")
    public void setIntrooWord(String introoWord) {
        this.introoWord = introoWord;
    }

    @Hidden
    @JsonProperty(value = "introword")
    public String getIntroWord() {
        return introWord;
    }
    @JsonProperty(value = "introWord")
    public void setIntroWord(String introWord) {
        this.introWord = introWord;
    }

    @Hidden
    @JsonProperty(value = "intext")
    public String getInText() {
        return inText;
    }
    @JsonProperty(value = "inText")
    public void setInText(String inText) {
        this.inText = inText;
    }

    @Hidden
    @JsonProperty(value = "introtext")
    public String getIntroText() {
        return introText;
    }

    @JsonProperty(value = "introText")
    public void setIntroText(String introText) {
        this.introText = introText;
    }

    @Hidden
    @JsonProperty(value = "introductiontext")
    public String getIntroductionText() {
        return introductionText;
    }

    @JsonProperty(value = "introductionText")
    public void setIntroductionText(String introductionText) {
        this.introductionText = introductionText;
    }
    @Hidden
    @JsonProperty(value = "exittext")
    public String getExitText() {
        return exitText;
    }

    @JsonProperty(value = "exitText")
    public void setExitText(String exitText) {
        this.exitText = exitText;
    }
}
