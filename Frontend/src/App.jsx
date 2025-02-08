import { useState } from 'react';
import './App.css';
import Account from './components/Account';
import Category from './components/Category';
import Form from './components/Chatbot';

import addIcon from './assets/add.svg';
import rightIcon from './assets/right.svg';
import leftIcon from './assets/left.svg';

function App() {
    const [accounts, setAccounts] = useState([
        { id: 0, account: 'Primary Account', money: 1000 }
    ]);

    const totalMoney = accounts.reduce((sum, account) => sum + account.money, 0);

    const [activeAccountIndex, setActiveAccountIndex] = useState(0);
    const [categories, setCategories] = useState([]);

    const addAccount = () => {
        setAccounts(prevAccounts => [
            ...prevAccounts,
            {
                id: prevAccounts.length,
                account: `Account ${prevAccounts.length}`,
                money: 500
            }
        ]);
    };

    const addCategory = () => {
        setCategories(prevCategories => [...prevCategories, { id: prevCategories.length }]);
    };

    const goToPreviousAccount = () => {
        if (activeAccountIndex === 0) {
            setActiveAccountIndex(accounts.length - 1);
        } else {
            setActiveAccountIndex(activeAccountIndex - 1);
        }
    };

    const goToNextAccount = () => {
        if (activeAccountIndex === accounts.length - 1) {
            setActiveAccountIndex(0);
        } else {
            setActiveAccountIndex(activeAccountIndex + 1);
        }
    };

    const currentAccount = accounts[activeAccountIndex];

    return (
        <div className='home'>
            <div className='bank-container'>
                <div className="navigation">
                    <button className='left-button' onClick={goToPreviousAccount}>
                        <img className="direction-button-img" src={leftIcon} alt="previous"/>
                    </button>
                    <button className='right-button' onClick={goToNextAccount}>
                        <img className="direction-button-img" src={rightIcon} alt="next"/>
                    </button>
                </div>
                <h1 className='section-title'>Bank Account</h1>
                <p className='total-money'>Total: £{totalMoney}</p>
                <Account money={currentAccount.money} accountName={currentAccount.account} />
                <div className='button-container' onClick={addAccount}>
                    <button className="add-btn">
                        <img className="add-btn-img" src={addIcon} alt="add"/>
                    </button>
                    <p className='button-text'>Add Account</p>
                </div>
            </div>
            <div className='categories-container'>
                <h1 className='section-title'>Money Division</h1>
                <div className='scrollview'>
                    <Category />
                    {categories.map(category => (
                        <Category key={category.id} />
                    ))}
                    <div className='button-container' onClick={addCategory}>
                        <button className="add-btn">
                            <img className="add-btn-img" src={addIcon} alt="add"/>
                        </button>
                        <p className='button-text'>Add Category</p>
                    </div>
                </div>
            </div>
            <div className='chatbot-container'>
                <Form />
            </div>
        </div>
    );
}

export default App;
