// import React, { useState, useEffect } from "react";
// import axios from 'axios';
// import { Bell, Edit, Trash2 } from 'lucide-react';
// import ReactQuill from 'react-quill';
// import 'react-quill/dist/quill.snow.css';
// import DateTimePicker from 'react-datetime-picker';
// import 'react-datetime-picker/dist/DateTimePicker.css';
// import "./HomeUi4.css";

// // API service functions
// const fetchNotices = async () => {
//   const response = await axios.get('http://localhost:8080/notices');
//   return response.data;
// };

// const createNotice = async (noticeData) => {
//   const response = await axios.post('http://localhost:8080/notices/add-notice', noticeData);
//   return response.data;
// };

// const updateNotice = async (id, noticeData) => {
//   const response = await axios.put(`http://localhost:8080/notices/${id}`, noticeData);
//   return response.data;
// };

// const deleteNotice = async (id) => {
//   await axios.delete(`http://localhost:8080/notices/${id}`);
// };

// // CSS styles
// const styles = `
//   .loading-spinner {
//     display: flex;
//     justify-content: center;
//     padding: 20px;
//     color: #3b82f6;
//   }
//   .error-message {
//     background-color: #fee2e2;
//     color: #dc2626;
//     padding: 10px;
//     border-radius: 4px;
//     margin-bottom: 15px;
//     text-align: center;
//   }
//   .notice-list {
//     display: flex;
//     flex-direction: column;
//     gap: 1.5rem;
//   }
//   .notice-card {
//     background: white;
//     border-radius: 0.5rem;
//     padding: 1.5rem;
//     box-shadow: 0 1px 3px rgba(0,0,0,0.1);
//     position: relative;
//   }
//   .notice-card h3 {
//     margin-top: 0;
//     color: #1e40af;
//   }
//   .notice-date {
//     color: #6b7280;
//     font-size: 0.875rem;
//     margin-bottom: 0.5rem;
//   }
//   .notice-content {
//     line-height: 1.6;
//   }
//   .notice-actions {
//     position: absolute;
//     top: 1rem;
//     right: 1rem;
//     display: flex;
//     gap: 0.5rem;
//   }
//   .notice-action-btn {
//     background: none;
//     border: none;
//     cursor: pointer;
//     color: #6b7280;
//     padding: 0.25rem;
//   }
//   .notice-action-btn:hover {
//     color: #1e40af;
//   }
//   .ql-container {
//     min-height: 200px;
//   }
// `;

// function Notices() {
//   const [notices, setNotices] = useState([]);
//   const [isLoading, setIsLoading] = useState(false);
//   const [error, setError] = useState(null);
//   const [showNoticeForm, setShowNoticeForm] = useState(false);
//   const [selectedNotice, setSelectedNotice] = useState(null);
  
//   const [noticeFormData, setNoticeFormData] = useState({
//     title: '',
//     content: '',
//     scheduleAt: new Date(),
//     isImportant: false
//   });

//   // Fetch notices from backend
//   useEffect(() => {
//     const loadNotices = async () => {
//       setIsLoading(true);
//       setError(null);
//       try {
//         const notices = await fetchNotices();
//         setNotices(notices);
//       } catch (err) {
//         setError('Failed to load notices. Please try again later.');
//         console.error('Error fetching notices:', err);
//       } finally {
//         setIsLoading(false);
//       }
//     };
//     loadNotices();
//   }, []);

//   // Form handlers
//   const handleNoticeFormChange = (name, value) => {
//     setNoticeFormData(prev => ({
//       ...prev,
//       [name]: value
//     }));
//   };

//   const handleNoticeSubmit = async (e) => {
//     e.preventDefault();
//     setIsLoading(true);
//     setError(null);
    
//     try {
//       if (selectedNotice) {
//         const updatedNotice = await updateNotice(selectedNotice._id, noticeFormData);
//         setNotices(notices.map(notice => 
//           notice._id === selectedNotice._id ? updatedNotice : notice
//         ));
//       } else {
//         const newNotice = await createNotice(noticeFormData);
//         setNotices([newNotice, ...notices]);
//       }
  
//       setShowNoticeForm(false);
//       setSelectedNotice(null);
//     } catch (err) {
//       setError(selectedNotice ? 'Failed to update notice' : 'Failed to create notice');
//       console.error('Error saving notice:', err);
//     } finally {
//       setIsLoading(false);
//     }
//   };

//   const handleNoticeDelete = async (id) => {
//     setIsLoading(true);
//     setError(null);
//     try {
//       await deleteNotice(id);
//       setNotices(notices.filter(notice => notice._id !== id));
//     } catch (err) {
//       setError('Failed to delete notice');
//       console.error('Error deleting notice:', err);
//     } finally {
//       setIsLoading(false);
//     }
//   };

//   const handleEditNotice = (notice) => {
//     setSelectedNotice(notice);
//     setNoticeFormData({
//       title: notice.title,
//       content: notice.content,
//       scheduleAt: new Date(notice.scheduleAt),
//       isImportant: notice.isImportant
//     });
//     setShowNoticeForm(true);
//   };

//   const formatDate = (dateString) => {
//     const options = { 
//       year: 'numeric', 
//       month: 'long', 
//       day: 'numeric',
//       hour: '2-digit',
//       minute: '2-digit'
//     };
//     return new Date(dateString).toLocaleDateString(undefined, options);
//   };

//   return (
//     <>
//       <style>{styles}</style>
//       <div>
//         {isLoading && <div className="loading-spinner">Loading notices...</div>}
//         {error && <div className="error-message">{error}</div>}
        
//         <div style={{ marginBottom: '1.5rem', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
//           <h2 className="section-title">Society Notices</h2>
//           <button 
//             className="btn btn-primary"
//             onClick={() => {
//               setShowNoticeForm(true);
//               setSelectedNotice(null);
//               setNoticeFormData({
//                 title: '',
//                 content: '',
//                 scheduleAt: new Date(),
//                 isImportant: false
//               });
//             }}
//             disabled={isLoading}
//           >
//             + Add Notice
//           </button>
//         </div>

//         <div className="notice-list">
//           {notices.map(notice => (
//             <div key={notice._id} className="notice-card">
//               <div className="notice-actions">
//                 <button 
//                   className="notice-action-btn"
//                   onClick={() => handleEditNotice(notice)}
//                   title="Edit"
//                 >
//                   <Edit size={16} />
//                 </button>
//                 <button 
//                   className="notice-action-btn"
//                   onClick={() => handleNoticeDelete(notice._id)}
//                   title="Delete"
//                 >
//                   <Trash2 size={16} />
//                 </button>
//               </div>
//               <div className="notice-date">
//                 {formatDate(notice.scheduleAt)}
//                 {notice.isImportant && <span style={{ color: '#dc2626', marginLeft: '0.5rem' }}>IMPORTANT</span>}
//               </div>
//               <h3>{notice.title}</h3>
//               <div 
//                 className="notice-content" 
//                 dangerouslySetInnerHTML={{ __html: notice.content }}
//               />
//             </div>
//           ))}
//         </div>

//         {/* Notice Form Modal */}
//         {showNoticeForm && (
//           <div style={{
//             position: 'fixed',
//             top: 0,
//             left: 0,
//             right: 0,
//             bottom: 0,
//             backgroundColor: 'rgba(0,0,0,0.5)',
//             display: 'flex',
//             alignItems: 'center',
//             justifyContent: 'center',
//             zIndex: 1000
//           }}>
//             <div style={{
//               backgroundColor: 'white',
//               padding: '2rem',
//               borderRadius: '0.5rem',
//               width: '100%',
//               maxWidth: '800px',
//               maxHeight: '90vh',
//               overflowY: 'auto'
//             }}>
//               <h2 style={{ marginBottom: '1.5rem' }}>
//                 {selectedNotice ? 'Edit Notice' : 'Add New Notice'}
//               </h2>
//               <form onSubmit={handleNoticeSubmit}>
//                 <div className="form-group" style={{ marginBottom: '1rem' }}>
//                   <label className="form-label">Title</label>
//                   <input
//                     className="form-input"
//                     type="text"
//                     value={noticeFormData.title}
//                     onChange={(e) => handleNoticeFormChange('title', e.target.value)}
//                     required
//                     disabled={isLoading}
//                   />
//                 </div>
                
//                 <div className="form-group" style={{ marginBottom: '1rem' }}>
//                   <label className="form-label">Schedule Date & Time</label>
//                   <DateTimePicker
//                     onChange={(value) => handleNoticeFormChange('scheduleAt', value)}
//                     value={noticeFormData.scheduleAt}
//                     disableClock={true}
//                     className="form-input"
//                   />
//                 </div>
                
//                 <div className="form-group" style={{ marginBottom: '1rem' }}>
//                   <label className="form-label">Content</label>
//                   <ReactQuill
//                     theme="snow"
//                     value={noticeFormData.content}
//                     onChange={(value) => handleNoticeFormChange('content', value)}
//                     modules={{
//                       toolbar: [
//                         [{ 'header': [1, 2, false] }],
//                         ['bold', 'italic', 'underline', 'strike'],
//                         [{'list': 'ordered'}, {'list': 'bullet'}],
//                         ['link', 'image'],
//                         ['clean']
//                       ]
//                     }}
//                   />
//                 </div>
                
//                 <div className="form-group" style={{ marginBottom: '1.5rem' }}>
//                   <label className="form-label">
//                     <input
//                       type="checkbox"
//                       checked={noticeFormData.isImportant}
//                       onChange={(e) => handleNoticeFormChange('isImportant', e.target.checked)}
//                       style={{ marginRight: '0.5rem' }}
//                       disabled={isLoading}
//                     />
//                     Mark as Important
//                   </label>
//                 </div>
                
//                 <div style={{ display: 'flex', justifyContent: 'flex-end', gap: '1rem' }}>
//                   <button
//                     type="button"
//                     className="btn btn-secondary"
//                     onClick={() => setShowNoticeForm(false)}
//                     disabled={isLoading}
//                   >
//                     Cancel
//                   </button>
//                   <button
//                     type="submit"
//                     className="btn btn-primary"
//                     disabled={isLoading}
//                   >
//                     {isLoading ? 'Saving...' : selectedNotice ? 'Update Notice' : 'Add Notice'}
//                   </button>
//                 </div>
//               </form>
//             </div>
//           </div>
//         )}
//       </div>
//     </>
//   );
// }

// export default Notices;
import React, { useState, useEffect } from "react";
import axios from 'axios';
import { Bell, Plus, Trash2, Loader2 } from 'lucide-react';
import DateTimePicker from 'react-datetime-picker';
import 'react-datetime-picker/dist/DateTimePicker.css';
import 'react-calendar/dist/Calendar.css';
import 'react-clock/dist/Clock.css';
import './Notice.css';

const API_BASE_URL = 'http://localhost:8080';

function Notices() {
  const [notices, setNotices] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [isDeleting, setIsDeleting] = useState(null);
  const [error, setError] = useState(null);
  const [showNoticeForm, setShowNoticeForm] = useState(false);
  const [newNotice, setNewNotice] = useState({
    title: '',
    content: '',
    scheduleAt: new Date(),
    isImportant: false,
    createdBy: JSON.parse(localStorage.getItem("userData"))?.name || "Admin"
  });

  // Fetch notices from backend
  useEffect(() => {
    const loadNotices = async () => {
      try {
        setIsLoading(true);
        const response = await axios.get(`${API_BASE_URL}/notices`, {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`
          }
        });
        setNotices(response.data);
      } catch (error) {
        setError('Failed to load notices. Please try again later.');
        console.error('Error fetching notices:', error);
      } finally {
        setIsLoading(false);
      }
    };
    loadNotices();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Basic client-side validation
    if (!newNotice.title.trim()) {
      setError("Title is required");
      return;
    }
    if (!newNotice.content.trim()) {
      setError("Content is required");
      return;
    }
  
    try {
      setIsLoading(true);
      setError(null);
      
      const response = await axios.post(
        `${API_BASE_URL}/notices`,
        {
          ...newNotice,
          scheduleAt: newNotice.scheduleAt.toISOString() // Convert to ISO string
        },
        {
          headers: {
            'Content-Type': 'application/json',
            Authorization: `Bearer ${localStorage.getItem("token")}`
          }
        }
      );
  
      if (response.status === 201) {
        setNotices([response.data, ...notices]);
        setShowNoticeForm(false);
        setNewNotice({
          title: '',
          content: '',
          scheduleAt: new Date(),
          isImportant: false,
          createdBy: JSON.parse(localStorage.getItem("userData"))?.name || "Admin"
        });
      }
    } catch (error) {
      console.error("Error creating notice:", error);
      setError(error.response?.data?.message || "Failed to create notice");
    } finally {
      setIsLoading(false);
    }
  };

  const handleDeleteNotice = async (id) => {
    if (!window.confirm('Are you sure you want to permanently delete this notice?')) {
      return;
    }
    
    try {
      setIsDeleting(id);
      await axios.delete(`${API_BASE_URL}/notices/${id}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem("token")}`
        }
      });
      setNotices(notices.filter(notice => notice.id !== id));
      setError(null);
    } catch (error) {
      setError(error.response?.data || 'Failed to delete notice. Please try again.');
      console.error('Error deleting notice:', error);
    } finally {
      setIsDeleting(null);
    }
  };

  const formatDate = (dateString) => {
    const date = new Date(dateString);
    return date.toLocaleString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  };

  return (
    <div className="notice-container">
      <div className="notice-header">
        <h1><Bell size={24} /> Notices</h1>
        <button 
          className="add-notice-btn"
          onClick={() => setShowNoticeForm(true)}
          disabled={isLoading}
        >
          <Plus size={16} /> Add Notice
        </button>
      </div>

      {error && <div className="error-message">{error}</div>}

      <div className="notice-content">
        {isLoading && notices.length === 0 ? (
          <div className="loading-spinner">
            <Loader2 className="spin" size={24} />
            Loading notices...
          </div>
        ) : notices.length === 0 ? (
          <div className="no-notices">No notices available</div>
        ) : (
          <div className="notice-list">
            {notices.map(notice => (
              <div key={notice.id} className="notice-card">
                <div className="notice-meta">
                  <span className="notice-date">{formatDate(notice.scheduleAt)}</span>
                  <span className="notice-author">{notice.createdBy || 'Admin'}</span>
                </div>
                <h3 className="notice-title">{notice.title}</h3>
                <div className="notice-content-text">{notice.content}</div>
                {notice.isImportant && (
                  <div className="notice-important">IMPORTANT</div>
                )}
                <button 
                  className="delete-btn"
                  onClick={() => handleDeleteNotice(notice.id)}
                  disabled={isDeleting === notice.id}
                >
                  {isDeleting === notice.id ? (
                    <>
                      <Loader2 className="spin" size={16} />
                      Deleting...
                    </>
                  ) : (
                    <>
                      <Trash2 size={16} />
                      Delete
                    </>
                  )}
                </button>
              </div>
            ))}
          </div>
        )}
      </div>

      {showNoticeForm && (
  <div className="notice-modal">
    <div className="modal-content">
      <div className="modal-header">
        <h2>Add New Notice</h2>
        <button 
          onClick={() => setShowNoticeForm(false)}
          disabled={isLoading}
          className="close-btn"
        >
          &times;
        </button>
      </div>
      
      {error && <div className="error-message">{error}</div>}
      
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Title*</label>
          <input
            type="text"
            value={newNotice.title}
            onChange={(e) => setNewNotice({...newNotice, title: e.target.value})}
            required
            disabled={isLoading}
          />
        </div>
        
        <div className="form-group">
          <label>Schedule Date & Time*</label>
          <DateTimePicker
            onChange={(date) => setNewNotice({...newNotice, scheduleAt: date})}
            value={newNotice.scheduleAt}
            disableClock={true}
            disabled={isLoading}
            minDate={new Date()} // Prevent selecting past dates
          />
        </div>
        
        <div className="form-group">
          <label>Content*</label>
          <textarea
            value={newNotice.content}
            onChange={(e) => setNewNotice({...newNotice, content: e.target.value})}
            rows={5}
            required
            disabled={isLoading}
          />
        </div>
        
        <div className="form-checkbox">
          <input
            type="checkbox"
            id="important"
            checked={newNotice.isImportant}
            onChange={(e) => setNewNotice({...newNotice, isImportant: e.target.checked})}
            disabled={isLoading}
          />
          <label htmlFor="important">Mark as important</label>
        </div>
        
        <div className="form-actions">
          <button 
            type="button" 
            className="btn-cancel"
            onClick={() => setShowNoticeForm(false)}
            disabled={isLoading}
          >
            Cancel
          </button>
          <button 
            type="submit" 
            className="btn-submit"
            disabled={isLoading}
          >
            {isLoading ? (
              <>
                <Loader2 className="spin" size={16} />
                Adding...
              </>
            ) : (
              'Add Notice'
            )}
          </button>
        </div>
      </form>
    </div>
  </div>
)}

    </div>
  );
}

export default Notices;