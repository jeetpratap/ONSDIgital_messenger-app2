import React, { useState } from 'react';
import axios from 'axios';

const MessageForm = () => {
    const [sender, setSender] = useState('');
    const [receiver, setReceiver] = useState('');
    const [content, setContent] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        const message = {
            sender: sender,
            receiver: receiver,
            content: content
        };

        axios.post('http://localhost:8000/api/messages/', message)
            .then(response => {
                console.log(response.data);
                setSender('');
                setReceiver('');
                setContent('');
            })
            .catch(error => {
                console.error("There was an error sending the message!", error);
            });
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Sender:</label>
                <input
                    type="text"
                    value={sender}
                    onChange={(e) => setSender(e.target.value)}
                />
            </div>
            <div>
                <label>Receiver:</label>
                <input
                    type="text"
                    value={receiver}
                    onChange={(e) => setReceiver(e.target.value)}
                />
            </div>
            <div>
                <label>Content:</label>
                <input
                    type="text"
                    value={content}
                    onChange={(e) => setContent(e.target.value)}
                />
            </div>
            <button type="submit">Send Message</button>
        </form>
    );
}

export default MessageForm;
