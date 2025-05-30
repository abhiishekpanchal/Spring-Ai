import React, { useState } from "react";

function Translator() {
    const [text, setText] = useState('');
    const [sourceLang, setSourceLang] = useState('English');
    const [targetLang, setTargetLang] = useState('Spanish');
    const [translatedText, setTranslatedText] = useState('');

    const translateText = async () => {
        try {
            const response = await fetch(
                `http://localhost:8080/translate?text=${encodeURIComponent(text)}&sourceLang=${encodeURIComponent(sourceLang)}&targetLang=${encodeURIComponent(targetLang)}`
            );
            const data = await response.text();
            setTranslatedText(data);
        } catch (error) {
            console.error("Error translating text: ", error);
        }
    };

    return (
        <div className="tab-content">
            <h2>Translator</h2>
            <input
                type="text"
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder="Enter text to translate"
            />
            <input
                type="text"
                value={sourceLang}
                onChange={(e) => setSourceLang(e.target.value)}
                placeholder="Source language (e.g., English)"
            />
            <input
                type="text"
                value={targetLang}
                onChange={(e) => setTargetLang(e.target.value)}
                placeholder="Target language (e.g., Spanish)"
            />
            <button onClick={translateText}>Translate</button>

            <div className="translated-output output">
                <p>{translatedText}</p>
            </div>
        </div>
    );
}

export default Translator;
