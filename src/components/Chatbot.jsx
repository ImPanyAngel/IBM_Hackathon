/* Inital design from Uiverse.io by ahmed150up */
import { useState } from 'react';
import styled from 'styled-components';

const Form = () => {
  const [messages, setMessages] = useState([]); // Stores chat messages
  const [inputValue, setInputValue] = useState(""); // Stores user input

  // Handle input change
  const handleInputChange = (event) => {
    setInputValue(event.target.value);
  };

  // Handle send message
  const handleSendMessage = () => {
    if (inputValue.trim() === "") return; // Prevent sending empty messages

    setMessages([...messages, inputValue]); // Add new message to the list
    setInputValue(""); // Clear the input field
  };

  return (
    <StyledCard>
      <div className="chat-header">AI ChatBot</div>
      <div className="chat-window">
        <ul className="message-list">
          {messages.map((msg, index) => (
            <li key={index} className="message">{msg}</li>
          ))}
        </ul>
      </div>
      <div className="chat-input">
        <input
          type="text"
          className="message-input"
          placeholder="Type your message here"
          value={inputValue}
          onChange={handleInputChange}
        />
        <button className="send-button" onClick={handleSendMessage}>
          Send
        </button>
      </div>
    </StyledCard>
  );
};

const StyledCard = styled.div`
  width: 100%;
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: column;
  justify-content: space-between;

  .chat-header {
    background-color: #333;
    color: #fff;
    padding: 10px;
    font-size: 18px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
  }

  .chat-window {
    height: 220px;
    overflow-y: auto;
    padding: 10px;
    border-bottom: 1px solid #ccc;
  }

  .message-list {
    list-style: none;
    margin: 0;
    padding: 0;
  }

  .message {
    background: #f1f1f1;
    padding: 8px;
    border-radius: 5px;
    margin-bottom: 5px;
    text-align: left;
  }

  .chat-input {
    display: flex;
    align-items: center;
    padding: 10px;
    border-top: 1px solid #ccc;
  }

  .message-input {
    flex: 1;
    border: none;
    outline: none;
    padding: 5px;
    font-size: 14px;
  }

  .send-button {
    border: none;
    outline: none;
    background-color: #333;
    color: #fff;
    font-size: 14px;
    padding: 5px 10px;
    cursor: pointer;
  }

  .send-button:hover {
    background-color: rgb(255, 255, 255);
    color: rgb(0, 0, 0);
    box-shadow: 0 4px 18px 0 rgba(0, 0, 0, 0.25);
  }
`;

export default Form;
