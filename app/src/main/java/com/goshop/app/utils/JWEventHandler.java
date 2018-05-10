package com.goshop.app.utils;

import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;

import com.longtailvideo.jwplayer.JWPlayerView;
import com.longtailvideo.jwplayer.core.PlayerState;
import com.longtailvideo.jwplayer.events.AdClickEvent;
import com.longtailvideo.jwplayer.events.AdCompleteEvent;
import com.longtailvideo.jwplayer.events.AdImpressionEvent;
import com.longtailvideo.jwplayer.events.AdPauseEvent;
import com.longtailvideo.jwplayer.events.AdPlayEvent;
import com.longtailvideo.jwplayer.events.AdSkippedEvent;
import com.longtailvideo.jwplayer.events.AdTimeEvent;
import com.longtailvideo.jwplayer.events.ControlsEvent;
import com.longtailvideo.jwplayer.events.ErrorEvent;
import com.longtailvideo.jwplayer.events.RelatedCloseEvent;
import com.longtailvideo.jwplayer.events.RelatedOpenEvent;
import com.longtailvideo.jwplayer.events.RelatedPlayEvent;
import com.longtailvideo.jwplayer.events.listeners.AdvertisingEvents;
import com.longtailvideo.jwplayer.events.listeners.VideoPlayerEvents;
import com.longtailvideo.jwplayer.media.adaptive.QualityLevel;
import com.longtailvideo.jwplayer.media.adaptive.VisualQuality;
import com.longtailvideo.jwplayer.media.audio.AudioTrack;
import com.longtailvideo.jwplayer.media.captions.Caption;
import com.longtailvideo.jwplayer.media.meta.Metadata;
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem;

import android.util.Log;
import android.widget.TextView;

import java.util.List;

/**
 * Outputs all JW Player Events to logging, with the exception of time events.
 */
public class JWEventHandler implements VideoPlayerEvents.OnSetupErrorListener,
    VideoPlayerEvents.OnPlaylistListener,
    VideoPlayerEvents.OnPlaylistItemListener,
    VideoPlayerEvents.OnPlayListener,
    VideoPlayerEvents.OnPauseListener,
    VideoPlayerEvents.OnBufferListener,
    VideoPlayerEvents.OnIdleListener,
    VideoPlayerEvents.OnErrorListenerV2,
    VideoPlayerEvents.OnSeekListener,
    VideoPlayerEvents.OnTimeListener,
    VideoPlayerEvents.OnFullscreenListener,
    VideoPlayerEvents.OnAudioTracksListener,
    VideoPlayerEvents.OnAudioTrackChangedListener,
    VideoPlayerEvents.OnCaptionsListListener,
    VideoPlayerEvents.OnMetaListener,
    VideoPlayerEvents.OnPlaylistCompleteListener,
    VideoPlayerEvents.OnCompleteListener,
    VideoPlayerEvents.OnLevelsChangedListener,
    VideoPlayerEvents.OnLevelsListener,
    VideoPlayerEvents.OnCaptionsChangedListener,
    VideoPlayerEvents.OnRelatedCloseListener,
    VideoPlayerEvents.OnControlsListener,
    VideoPlayerEvents.OnDisplayClickListener,
    VideoPlayerEvents.OnMuteListener,
    VideoPlayerEvents.OnRelatedOpenListener,
    VideoPlayerEvents.OnRelatedPlayListener,
    VideoPlayerEvents.OnSeekedListener,
    VideoPlayerEvents.OnVisualQualityListener,
    AdvertisingEvents.OnAdClickListenerV2,
    AdvertisingEvents.OnAdCompleteListenerV2,
    AdvertisingEvents.OnAdSkippedListenerV2,
    AdvertisingEvents.OnAdErrorListener,
    AdvertisingEvents.OnAdImpressionListenerV2,
    AdvertisingEvents.OnAdTimeListenerV2,
    AdvertisingEvents.OnAdPauseListenerV2,
    AdvertisingEvents.OnAdPlayListenerV2,
    AdvertisingEvents.OnBeforePlayListener,
    AdvertisingEvents.OnBeforeCompleteListener {

    int position;

    private static final String TAG = "JWEventHandler";

    public JWEventHandler(JWPlayerView jwPlayerView, int position) {
        this.position = position;
        jwPlayerView.addOnSetupErrorListener(this);
        jwPlayerView.addOnPlaylistListener(this);
        jwPlayerView.addOnPlaylistItemListener(this);
        jwPlayerView.addOnPlayListener(this);
        jwPlayerView.addOnPauseListener(this);
        jwPlayerView.addOnBufferListener(this);
        jwPlayerView.addOnIdleListener(this);
        jwPlayerView.addOnErrorListener(this);
        jwPlayerView.addOnSeekListener(this);
        jwPlayerView.addOnTimeListener(this);
        jwPlayerView.addOnFullscreenListener(this);
        jwPlayerView.addOnLevelsChangedListener(this);
        jwPlayerView.addOnLevelsListener(this);
        jwPlayerView.addOnCaptionsListListener(this);
        jwPlayerView.addOnCaptionsChangedListener(this);
        jwPlayerView.addOnRelatedCloseListener(this);
        jwPlayerView.addOnRelatedOpenListener(this);
        jwPlayerView.addOnRelatedPlayListener(this);
        jwPlayerView.addOnControlsListener(this);
        jwPlayerView.addOnDisplayClickListener(this);
        jwPlayerView.addOnMuteListener(this);
        jwPlayerView.addOnVisualQualityListener(this);
        jwPlayerView.addOnSeekedListener(this);
        jwPlayerView.addOnAdClickListener(this);
        jwPlayerView.addOnAdCompleteListener(this);
        jwPlayerView.addOnAdSkippedListener(this);
        jwPlayerView.addOnAdErrorListener(this);
        jwPlayerView.addOnAdImpressionListener(this);
        jwPlayerView.addOnAdTimeListener(this);
        jwPlayerView.addOnAdPauseListener(this);
        jwPlayerView.addOnAdPlayListener(this);
        jwPlayerView.addOnMetaListener(this);
        jwPlayerView.addOnPlaylistCompleteListener(this);
        jwPlayerView.addOnCompleteListener(this);
        jwPlayerView.addOnBeforePlayListener(this);
        jwPlayerView.addOnBeforeCompleteListener(this);
    }

    private void updateOutput(String output) {
        JLogUtils.d(TAG, output);
    }

    /**
     * Regular playback events below here
     */
    @Override
    public void onAudioTracks(List<AudioTrack> audioTracks) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onBeforeComplete() {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onBeforePlay() {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onBuffer(PlayerState oldState) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onCaptionsList(List<Caption> tracks) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onComplete() {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onFullscreen(boolean fullscreen) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onIdle(PlayerState oldState) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onMeta(Metadata meta) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
        if (meta.getId3Metadata().size() > 0) {
            List<Id3Frame> id3 = meta.getId3Metadata();
            for (Id3Frame id3Obj : id3) {
                if (id3Obj instanceof TextInformationFrame) {
                    TextInformationFrame txxxFrame = (TextInformationFrame) id3Obj;
                } else if (id3Obj instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) id3Obj;
                } else if (id3Obj instanceof GeobFrame) {
                    GeobFrame geobFrame = (GeobFrame) id3Obj;
                } else if (id3Obj instanceof BinaryFrame) {
                    BinaryFrame binaryFrame = (BinaryFrame) id3Obj;
                }
            }
        }
    }

    @Override
    public void onPause(PlayerState oldState) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onPlay(PlayerState oldState) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onPlaylistComplete() {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onPlaylistItem(int index, PlaylistItem playlistItem) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onPlaylist(List<PlaylistItem> playlist) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onSeek(int position, int offset) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onSetupError(String message) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onTime(long position, long duration) {
        // TODO: 2018/5/10   Do nothing - this fires several times per second
    }

    @Override
    public void onAdError(String tag, String message) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onError(ErrorEvent errorEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onLevelsChanged(int i) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onLevels(List<QualityLevel> list) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAudioTrackChanged(int i) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onCaptionsChanged(int i, List<Caption> list) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAdClick(AdClickEvent adClickEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAdComplete(AdCompleteEvent adCompleteEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAdSkipped(AdSkippedEvent adSkippedEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAdImpression(AdImpressionEvent adImpressionEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAdTime(AdTimeEvent adTimeEvent) {
        // TODO: 2018/5/10  Do nothing - this fires several times per second
    }

    @Override
    public void onAdPause(AdPauseEvent adPauseEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onAdPlay(AdPlayEvent adPlayEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onRelatedClose(RelatedCloseEvent relatedCloseEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onControls(ControlsEvent controlsEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onDisplayClick() {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onMute(boolean b) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onRelatedOpen(RelatedOpenEvent relatedOpenEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onRelatedPlay(RelatedPlayEvent relatedPlayEvent) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onSeeked() {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }

    @Override
    public void onVisualQuality(VisualQuality visualQuality) {
        // TODO: 2018/5/10 JW Player events callback method used to debug video
    }
}
